package com.example.miguelguerra1.kva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Producto extends AppCompatActivity {

    private String nombreP;
    private String precioP;
    private String tipoP;
    private String ID;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
    }
}
