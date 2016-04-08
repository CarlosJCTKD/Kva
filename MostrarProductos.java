package com.example.miguelguerra1.kva;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MostrarProductos extends AppCompatActivity
{
    private static ArrayList<String> tipos = new ArrayList<String>();

    public MostrarProductos()
    {

    }

    public static void setArreglo(ArrayList<String> list)
    {
        tipos = list;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_productos);

        final ListView listaProductos = (ListView) findViewById(R.id.listaProductos);
        //tipos = new ArrayList<String>();
        //tipos.add("Vinos");

        for(int i = 0; i < 4; i++)
        {
            System.out.print(tipos.get(i));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tipos);

        listaProductos.setAdapter(arrayAdapter);

        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                String selectedFromList =(String) (listaProductos.getItemAtPosition(myItemInt));

            }
        });
    }
}
