package com.example.miguelguerra1.kva;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BDProducto extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Productos.db";
    private static final String TABLE_NAME = "productos";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_PRECIO = "precio";
    private static final String COLUMN_TIPO = "tipo";
    private static final String COLUMN_DESCRIPCION = "descripcion";

    SQLiteDatabase dbP;
    int tamcat = 5;

    BDProducto(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String TABLE_CREATE = "CREATE TABLE productos (id INTEGER PRIMARY KEY, "+"" +
                " nombre TEXT, precio TEXT, tipo TEXT, descripcion TEXT)";
        db.execSQL(TABLE_CREATE);
        this.dbP = db;
    }

    public void insertarProducto(Producto p) throws SQLException
    {
        dbP = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, p.getNombre());
        values.put(COLUMN_PRECIO, p.getPrecio());
        values.put(COLUMN_TIPO, p.getTipo());
        values.put(COLUMN_DESCRIPCION, p.getDescripcion());

        dbP.insert(TABLE_NAME, null, values);

        dbP.close();
    }

    public void listProductos(String tipo) throws SQLException
    {
        dbP = this.getWritableDatabase();
        String query= "select tipo, nombre, precio from "+TABLE_NAME;
        Cursor c = dbP.rawQuery(query, null);


        ArrayList<String> productos= new ArrayList<String>();
        int i = 0;
        String t, n = "Not found", p = "Not found";
        if (c.moveToFirst())
        {
            do
            {
                t = c.getString(0);
                if(t.equals(tipo))
                {
                    i++;
                    n = c.getString(1);
                    p = c.getString(2);
                    productos.add(tipo +"  "+ n + "  "+ p );

                    break;
                }
            }while (c.moveToNext());

            if(i != 0)
            {
                MostrarProductos.setArreglo(productos);
            }

        }

    }

    public void insertarProductol() throws SQLException
    {
        for(int i = 0; i < 4; i++) {
            dbP = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_NOMBRE, "Papis"+i);
            values.put(COLUMN_PRECIO, "$1.00");
            values.put(COLUMN_TIPO, "VinoTinto");
            values.put(COLUMN_DESCRIPCION, "Holis");

            dbP.insert(TABLE_NAME, null, values);

            dbP.close();
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
