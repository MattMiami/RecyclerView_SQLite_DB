package com.example.sqlite_recycler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Ctrl_Contactos extends DB_Contactos {


    public Ctrl_Contactos(Context context) {
        super(context);
    }

//-----------------------------------------------------

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
            valores.put("GPS_x", c.getGPS_x());
            valores.put("GPS_y", c.getGPS_y());

            resgitros_afectados = db.insert("Contactos", null, valores);
        }
        db.close();
        return resgitros_afectados;
    }

    //-----------------------------------------------------------

    public long borrar(String dni){
        long registros_afectados = 0;

        SQLiteDatabase db = getWritableDatabase();

        if(db != null){
            ContentValues valores = new ContentValues();
            registros_afectados =    db.delete("Contactos", "dni= " + dni, null);
        }
        db.close();
        return registros_afectados;

    }

    //----------------------------------------------------------

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
            valores.put("GPS_x", c.getGPS_x());
            valores.put("GPS_y", c.getGPS_y());

            resgitros_afectados = db.update("Contactos", valores, "dni=" + c.getDni(), null);
        }
        db.close();
        return resgitros_afectados;
    }

    //-----------------------------------------------------------
    public ArrayList<Contacto> listarContactos(){
        SQLiteDatabase db=getReadableDatabase();
        Contacto c;
        List<Contacto> listaContacto=new ArrayList<>();
        if(db!=null){
            String[] campos = {"dni","name","surname","mail","address","phone","GPS_x","GPS_Y"};
            Cursor cursor = db.query("Contactos",campos,null,null,null,null,null);
            if(cursor.moveToFirst()){
                do{
                    c=new Contacto(cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getString(5),
                            cursor.getFloat(6),
                            cursor.getFloat(7));
                    listaContacto.add(c);
                }while(cursor.moveToNext());
            }
            cursor.close();
        }
        db.close();
        return (ArrayList) listaContacto;
    }
}
