package com.example.sqlite_recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usuario, password, prefeUsu, prefePass ;
   // private Button login, btRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = (EditText) findViewById(R.id.et_usuario);
        password = (EditText) findViewById(R.id.et_password);
       // login = (Button) findViewById(R.id.btLogin);
       // btRegistrar = (Button) findViewById(R.id.btRegistrar);

    }

    // VERIFICAMOS USER Y PASSWORD QUE TENEMOS GUARDADOS Y SI SON CORRECTOS ENTRAMOS
    public void login(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String user = prefs.getString("usuario","user");
        String pass = prefs.getString("contrasenha","pass");
        if(user.equals(usuario.getText().toString())&&pass.equals(password.getText().toString())){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }
    }

    // EDITAMOS LAS PREFS PARA AÑADIR UN NUEVO USUARIO
    public void registre(View view){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("usuario", usuario.getText().toString());
        edit.putString("contrasenha", password.getText().toString());
        if (usuario.getText().toString().isEmpty()|| password.getText().toString().isEmpty()){
            Toast.makeText(this, "Para resgistrarte debes introducir un Usuario y una Contaseña", Toast.LENGTH_SHORT).show();
        }else{
            edit.commit();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }




}