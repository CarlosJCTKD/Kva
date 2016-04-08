package com.example.miguelguerra1.kva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.sql.SQLException;

public class Registro extends AppCompatActivity
{
    BDUsuario usuario = new BDUsuario(this);

    public void registrar(View view) throws SQLException
    {
        EditText nombre = (EditText) findViewById(R.id.nombreText);
        EditText apellido = (EditText) findViewById(R.id.apellidoText);
        EditText correo = (EditText) findViewById(R.id.correoText);
        EditText contraseña = (EditText) findViewById(R.id.passwordText);

        String nombrest = nombre.getText().toString();
        String apellidost = apellido.getText().toString();
        String correost = correo.getText().toString();
        String contraseñast = contraseña.getText().toString();

        Usuario usr = new Usuario(nombrest, apellidost, correost, contraseñast);

        usuario.insertarUsuario(usr);

        startActivity(new Intent(Registro.this, RegistroMovil.class));
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }
}
