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

}
