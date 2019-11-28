package com.example.pruebafinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Formulario_DB  extends SQLiteOpenHelper {

    private static final String NOMBRE_DB = "Formulario.db";
    private static final int VERSION_DB = 1;
    private static final String TABLA_CURSOS = "CREATE TABLE CURSOS(CODIGO TEXT PRIMARY KEY, CURSO TEXT, CARRERA TEXT)";

    public Formulario_DB(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
         sqLiteDatabase.execSQL(TABLA_CURSOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_CURSOS);
        sqLiteDatabase.execSQL(TABLA_CURSOS);
    }

    public void agregarCursos(String codigo, String curso, String carrera){
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("INSERT INTO CURSOS VALUES ('"+codigo+"','"+curso+"','"+carrera+"')");
            db.close();
        }

    }
}
