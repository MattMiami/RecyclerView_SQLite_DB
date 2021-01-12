package com.example.sqlite_recycler;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_Contactos extends SQLiteOpenHelper {

    private static Contacto contacto;

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "DB_Contactos.db";
    private static final String TABLE_NAME = "Contactos";

    private static final String instruction = "CREATE TABLE " + TABLE_NAME + " (dni VARCHAR(10) PRIMARY KEY," +
            " name VARCHAR(100)," +
            " surname VARCHAR(100)," +
            " mail VARCHAR(100)," +
            " address VARCHAR(100)," +
            " phone VARCHAR(20)," +
            " GPS_x FLOAT," +
            " GPS_y FLOAT)";

    public DB_Contactos(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(instruction);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //---------------------------------------Metodos propios de SQLITEDATABASE para tratar registros----------------------------------------


    public long insertar(Contacto c){

        long resgitros_afectados = -1;

        //Para poder leer y escribir en  la base de datos
        SQLiteDatabase db = getWritableDatabase();

        if(db != null){
            ContentValues valores = new ContentValues();

            valores.put("dni", c.getDni());
            valores.put("name", c.getName());
            valores.put("surname", c.getSurname());
            valores.put("mail", c.getMail());
            valores.put("address", c.getAddress());
            valores.put("phone", c.getPhone());
            valores.put("GSP_x", c.getGPS_x());
            valores.put("GPS_y", c.getGPS_y());

            resgitros_afectados = db.insert(TABLE_NAME, null, valores);
        }
        db.close();
        return resgitros_afectados;
    }

    public long borrar(String dni){

        long resgitros_afectados = 0;

        SQLiteDatabase db = getWritableDatabase();

        if(db != null){

            resgitros_afectados = db.delete(TABLE_NAME, "dni=" + dni, null);
        }
        db.close();
        return resgitros_afectados;
    }

    public long modificar(Contacto c){
        long resgitros_afectados = -1;

        SQLiteDatabase db = getWritableDatabase();

        if(db != null){
            ContentValues valores = new ContentValues();

            valores.put("dni", c.getDni());
            valores.put("name", c.getName());
            valores.put("surname", c.getSurname());
            valores.put("mail", c.getMail());
            valores.put("address", c.getAddress());
            valores.put("phone", c.getPhone());
            valores.put("GSP_x", c.getGPS_x());
            valores.put("GPS_y", c.getGPS_y());

            resgitros_afectados = db.update(TABLE_NAME, valores, "dni=" + c.getDni(), null);
        }
        db.close();
        return resgitros_afectados;
    }

}
