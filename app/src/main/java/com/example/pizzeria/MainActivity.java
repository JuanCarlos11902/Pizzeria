package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void comprobarUsuario(View view){
        Usuario usuario = new Usuario(1,null,"Juan Carlos","Pérez","kalolo","kalolo");

        TextView txtUsuario = findViewById(R.id.textoUsuario);
        TextView txtContraseña = findViewById(R.id.textView2);
        TextView txtAviso = findViewById(R.id.textView3);

        if (txtUsuario.getText().toString().equals(usuario.getUsuario()) == false && txtContraseña.getText().toString().equals(usuario.getConstraseña()) == false) {
            txtAviso.setVisibility(View.VISIBLE);
        }

        else{

        }

    }
}