package com.example.miguelguerra1.kva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Catalogo extends AppCompatActivity
{
    BDProducto bdProducto = new BDProducto(this);

    public void menu(View view)
    {
        startActivity(new Intent(Catalogo.this, Menu.class));
    }

    public void vinosTintos(View view)
    {
        bdProducto.insertarProductol();
        bdProducto.listProductos("VinoTinto");
        startActivity(new Intent(Catalogo.this, MostrarProductos.class));
    }

    public void vinosBlancos(View view)
    {
        bdProducto.listProductos("VinoBlanco");
        startActivity(new Intent(Catalogo.this, MostrarProductos.class));
    }

    public void espumosos(View view)
    {
        bdProducto.listProductos("Espumosos");
        startActivity(new Intent(Catalogo.this, MostrarProductos.class));
    }

    public void embutidos(View view)
    {
        bdProducto.listProductos("Embutidos");
        startActivity(new Intent(Catalogo.this, MostrarProductos.class));
    }

    public void quesos(View view)
    {
        bdProducto.listProductos("Quesos");
        startActivity(new Intent(Catalogo.this, MostrarProductos.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
    }
}
