package com.example.byekiloh.utilidades;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.byekiloh.utilidades.Tablas.*;

public class BaseDatos extends SQLiteOpenHelper {

    //Se declaran e inicializan las variables encargadas de almacenar las consultas para crear las tablas,
    //y las consultas de eliminar/crear la Base de Datos 'alphaFinalizada.sqlite'.
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + EstructuraUsuario.TABLE_NAME + " (" +
                EstructuraUsuario._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                EstructuraUsuario.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                EstructuraUsuario.COLUMN_NAME_PASS + TEXT_TYPE + " )";

    private static final String SQL_CREATE_ENTRIES2 =
        "CREATE TABLE " + EstructuraCuenta.TABLE_NAME + " (" +
                EstructuraCuenta._IDUSER + " INTEGER," +
                EstructuraCuenta.COLUMN_NAME_SEXO + TEXT_TYPE + COMMA_SEP +
                EstructuraCuenta.COLUMN_NAME_NOMBRE + TEXT_TYPE + COMMA_SEP +
                EstructuraCuenta.COLUMN_NAME_DIRECCION + TEXT_TYPE + COMMA_SEP +
                EstructuraCuenta.COLUMN_NAME_LOCALIDAD + TEXT_TYPE + COMMA_SEP +
                EstructuraCuenta.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
                EstructuraCuenta.COLUMN_NAME_FECHANAC + TEXT_TYPE + " )";

    private static final String SQL_CREATE_ENTRIES3 =
            "CREATE TABLE " + EstructuraEjercicio.TABLE_NAME + " (" +
                    EstructuraEjercicio._IDEJERCICIO + " INTEGER PRIMARY KEY, " +
                    EstructuraEjercicio.COLUMN_NAME_DISTANCIA + TEXT_TYPE + COMMA_SEP +
                    EstructuraEjercicio.COLUMN_NAME_TIEMPO + TEXT_TYPE + " )";


    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + EstructuraUsuario.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES2 = "DROP TABLE IF EXISTS " + EstructuraCuenta.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES3 = "DROP TABLE IF EXISTS " + EstructuraEjercicio.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "alphaFinalizada.sqlite";

    public BaseDatos(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION); }

    //Método para crear la Tabla que recibe la consulta Transact-SQL
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES2);
        db.execSQL(SQL_CREATE_ENTRIES3);

    }

    //Método que elimina la tabla y vuelve a llamar al método que la crea
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_DELETE_ENTRIES2);
        db.execSQL(SQL_DELETE_ENTRIES3);
        onCreate(db);

    }

}