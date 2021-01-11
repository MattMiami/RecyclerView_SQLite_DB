package com.example.sqlite_recycler;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    //Variable para trabajar con nuestro recycler view
    private RecyclerView rvContactos;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    //Variable base de datos
    DB_Contactos db;
    Contacto c;
    List<Contacto> lista;
    long registros_afectados = -1;

    /*Textos*/
    EditText etDni;
    EditText etName;
    EditText etSurname;
    EditText etMail;
    EditText etAddress;
    EditText etPhone;
    EditText etGPS_x;
    EditText etGPS_y;

    /*Botones*/
    Button btAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//-------------------------RecyclerView and Adapter---------------------------
      /*  //Inicializamos el recycler
        rvContactos = (RecyclerView) findViewById(R.id.rvCotactos);
        //Asignamos el itemView a nuestro recycler view
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvContactos.setLayoutManager(layoutManager);
        //Inicializamos el adaptador y lo asociamos al recycler
        //rvContactos.setAdapter(adapter);
        */

//------------------------Base de datos--------------------------------------

        /*Acceso a la base de datos*/
        db = new DB_Contactos(this);

        /*Views de datos para tratar con la base de datos*/

        etDni = (EditText) findViewById(R.id.etDni);
        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etMail = (EditText) findViewById(R.id.etMail);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etGPS_x = (EditText) findViewById(R.id.etGPS_x);
        etGPS_y = (EditText) findViewById(R.id.etGPS_y);

        /*Botones*/
        btAdd = (Button) findViewById(R.id.btAdd);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alta(v);
            }
        });


//-------------------------Navigation Drawer-------------------------------
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_contactos)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        //NOS CARGARÁ EL MENU DE PREFERENCIAS
        if(id == R.id.menu_preferencias){
            Intent intent = new Intent(this, Preferencias.class);
            startActivity(intent);
        }

        //Este super tiene que estar al final del método para que funcione
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

//-----------------------------------Metodos base de datos------------------------------------------

    //String dni, String name, String surname, String mail, String address, String phone, Float GPS_x, Float GPS_y
    public void alta(View v){
         c = new Contacto(etDni.getText().toString(),
                 etName.getText().toString(),
                 etSurname.getText().toString(),
                 etMail.getText().toString(),
                 etAddress.getText().toString(),
                 etPhone.getText().toString(),
                 Float.valueOf(etGPS_x.getText().toString()),
                 Float.valueOf(etGPS_y.getText().toString()));
         registros_afectados = db.insetar(c);

         if(registros_afectados <= 0){
             Toast.makeText(this,"Error al insertar registro", Toast.LENGTH_SHORT).show();
         }
    }



}