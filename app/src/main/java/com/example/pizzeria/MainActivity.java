package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Servicio servicio = new Servicio();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void comprobarUsuario(View view){

        TextView txtUsuario = findViewById(R.id.textoUsuario);
        TextView txtContraseña = findViewById(R.id.textView2);
        TextView txtAviso = findViewById(R.id.textView3);

        boolean flag = false;

        for (int i = 0; i < servicio.getListaUsuarios().size(); i++) {
            if (servicio.getListaUsuarios().get(i).getUsuario().equals(txtUsuario.getText().toString())
            && servicio.getListaUsuarios().get(i).getConstraseña().equals(txtContraseña.getText().toString())){
                flag = true;
            }
        }

        if (flag == true){
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
        }
        else{
            txtAviso.setVisibility(View.VISIBLE);
        }



    }
}