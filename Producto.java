package com.example.miguelguerra1.kva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Producto extends AppCompatActivity {

    private String nombreP;
    private String precioP;
    private String tipoP;
    private String id;
    private String descripcionP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
    }

    public Producto(String nombre, String precio, String tipoP, String id, String descripcionP)
    {
    	this.id = id;
    	this.nombreP = nombre;
    	this.precioP = precio;
    	this.tipoP = tipoP;
    	this.descripcionP = descripcionP; 
    }

    public String getID()
    {
    	return this.id;
    }

    public void setID(String id)
    {
    	this.id = id;
    }

    public String getNombre()
    {
    	return this.nombreP;
    }

    public void setNombre(String nombreP)
    {
    	this.nombreP = nombreP;
    }

    public String getIPrecio()
    {
    	return this.precioP;
    }

    public void setPrecio(String precioP)
    {
    	this.precioP = precioP;
    }

    public String getTipo()
    {
    	return this.tipoP;
    }

    public void setTipo(String tipoP)
    {
    	this.tipoP = tipoP;
    }

    public String getDescripcion()
    {
    	return this.descripcionP;
    }

    public void setDescripcion(String descripcionP)
    {
    	this.descripcionP = descripcionP;
    }

}
