package com.example.sqlite_recycler.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sqlite_recycler.Contacto;
import com.example.sqlite_recycler.Ctrl_Contactos;
import com.example.sqlite_recycler.R;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    //Variable base de datos
    Ctrl_Contactos controlador;
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
    Button btDelete;
    Button btMod;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        /*Acceso a la base de datos*/
        controlador = new Ctrl_Contactos(getContext());

        /*Views de datos para tratar con la base de datos*/
        etDni = root.findViewById(R.id.etDni);
        etName = root.findViewById(R.id.etName);
        etSurname = root.findViewById(R.id.etSurname);
        etMail = root.findViewById(R.id.etMail);
        etAddress = root.findViewById(R.id.etAddress);
        etPhone = root.findViewById(R.id.etPhone);
        etGPS_x = root.findViewById(R.id.etGPS_x);
        etGPS_y = root.findViewById(R.id.etGPS_y);


        /*Botones*/
        btAdd = root.findViewById(R.id.btAdd);
        btDelete = root.findViewById(R.id.btDelete);
        btMod = root.findViewById(R.id.btMod);

        Toast.makeText(getContext(), " Tamaño " + controlador.listarContactos().size(), Toast.LENGTH_SHORT).show();


        //--------------------BOTON ALTA CONTACTO------------------------------------

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = new Contacto(etDni.getText().toString(),
                        etName.getText().toString(),
                        etSurname.getText().toString(),
                        etMail.getText().toString(),
                        etAddress.getText().toString(),
                        etPhone.getText().toString(),
                        Float.valueOf(etGPS_x.getText().toString()),
                        Float.valueOf(etGPS_y.getText().toString()));


                if (controlador.insertar(c) != -1) {
                    Toast.makeText(getContext(), "Alta correcta", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Error al insertar registro", Toast.LENGTH_SHORT).show();
                }
            }

        });

        //-----------------------BOTON BAJA CONTACTO----------------------------------

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = etDni.getText().toString();
                if (controlador.borrar(dni) > 0) {
                    Toast.makeText(getContext(), "Eliminado correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Error al borrar registro", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //---------------------BOTON MODIFICAR CONTACTO--------------------------------

        btMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = new Contacto(etDni.getText().toString(),
                        etName.getText().toString(),
                        etSurname.getText().toString(),
                        etMail.getText().toString(),
                        etAddress.getText().toString(),
                        etPhone.getText().toString(),
                        Float.parseFloat(etGPS_x.getText().toString()),
                        Float.parseFloat(etGPS_y.getText().toString()));
                if (controlador.modificar(c) > 0) {
                    Toast.makeText(getContext(), "Modificado correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Error al modificar registro", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }


}