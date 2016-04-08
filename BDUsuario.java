package com.example.miguelguerra1.kva;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;


public class BDUsuario extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "usuarios.db";
    private static final String TABLE_NAME = "Users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_APELLIDO = "apellido";
    private static final String COLUMN_CORREO = "correo";
    private static final String COLUMN_CONTRASEÑA= "contraseña";
    private static final String COLUMN_TELEFONO = "telefono";
    private static final String COLUMN_TARJETACREDITO = "tarjetaCredito";
    SQLiteDatabase db;

    public BDUsuario(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String TABLE_CREATE = "CREATE TABLE Users (id INTEGER PRIMARY KEY, "+"" +
                " nombre TEXT, apellido TEXT, correo TEXT, contraseña TEXT, telefono TEXT, tarjetaCredito TEXT)";
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertarUsuario(Usuario u) throws SQLException
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NOMBRE, u.getNombre());
        values.put(COLUMN_APELLIDO, u.getApellido());
        values.put(COLUMN_CORREO, u.getCorreo());
        values.put(COLUMN_CONTRASEÑA, u.getContraseña());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public String checarLogIn(String e) throws SQLException
    {
        db = this.getWritableDatabase();
        String query = "select correo, contraseña from "+TABLE_NAME;
        Cursor c = db.rawQuery(query, null);

        String a, b = "Not found";
        if (c.moveToFirst())
        {
            do
            {
                a = c.getString(0);

                if(a.equals(e))
                {
                    b = c.getString(1);
                    break;
                }
            }while (c.moveToNext());
        }

        return b;
    }

    public boolean checarTelefono(String telefono,String codigo) throws SQLException
    {
        if (codigo.equals("12345"))
        {
            db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(COLUMN_TELEFONO, telefono);
            db.insert(TABLE_NAME, null, values);

            db.close();
            return true;
        }
        else
        {
            return false;
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query = "DROP TABLE IF EXIST " +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

}
