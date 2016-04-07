package com.example.miguelguerra1.kva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity
{
    BDUsuario bdUsuario = new BDUsuario(this);

    public void entrarLogIn(View view) throws SQLException
    {
        EditText email = (EditText) findViewById(R.id.emailText);
        EditText contraseña = (EditText) findViewById(R.id.contraseñaText);

        String emailst = email.getText().toString();
        String contraseñast = contraseña.getText().toString();

        String pass = bdUsuario.checarLogIn(emailst);
        if(contraseñast.equals(pass))
        {
            Intent i = new Intent(MainActivity.this, Display.class);
            i.putExtra("mike", emailst);
            startActivity(i);
        }
        else
        {
            Toast toast = Toast.makeText(MainActivity.this, "Email o Contraseña incorrecta! intenta nuevamente.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void registrate(View view)
    {
        startActivity(new Intent(MainActivity.this, Registro.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        try
        {
            //Crea un dataBase para guardar los datos de los usuarios
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            //crea un tabla para contener difrente información
            //myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            //Crear una ID
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCAHR, age INTEGER(3), id INTEGER PRIMARY KEY)");

            //Insertar datos
            //myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Miguel', 27)");
            //myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Siria', 30)");
            //myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Carolina', 50)");
            //myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Rene', 50)");

            //Eliminar un usuario o todos los usuarios con ese nombre de tu database
            //myDatabase.execSQL("DELETE FROM newUsers WHERE id = 2");

            //Hacer cambios en el database
            //myDatabase.execSQL("UPDATE users SET age = 2 WHERE name = 'Miguel'");

            //sacar los datos del database
            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);

            //Para buscar un solo user name
            //c = myDatabase.rawQuery("SELECT * FROM users WHERE name = 'Miguel'", null);



            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            c.moveToFirst();
            while (c != null)
            {
                Log.i("name", c.getString(nameIndex));
                Log.i("age", c.getString(ageIndex));
                Log.i("id", c.getString(idIndex));

                c.moveToNext();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
*/
    }
}
