package com.example.miguelguerra1.kva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class RegistroMovil extends AppCompatActivity
{
    BDUsuario bdUsuario = new BDUsuario(this);

    public void continuar(View view) throws SQLException
    {
        EditText tel = (EditText) findViewById(R.id.telText);
        EditText cod = (EditText) findViewById(R.id.codigoText);

        String telefono = tel.getText().toString();
        String codigo = cod.getText().toString();

        if(bdUsuario.checarTelefono(telefono, codigo))
        {
            Toast toast = Toast.makeText(RegistroMovil.this, "Bienvenido!", Toast.LENGTH_SHORT);
            toast.show();
            startActivity(new Intent(RegistroMovil.this, Catalogo.class));
        }
        else
        {
            Toast toast = Toast.makeText(RegistroMovil.this, "Tu código es incorrecto! Intente nuevamente.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_movil);
    }
}
