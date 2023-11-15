package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

        TextView txtUsuario = findViewById(R.id.textoUsuario);
        TextView txtContraseña = findViewById(R.id.textView2);
        TextView txtAviso = findViewById(R.id.textView3);

        boolean flag = false;

        for (int i = 0; i < Servicio.getInstance().getListaUsuarios().size(); i++) {
            if (Servicio.getInstance().getListaUsuarios().get(i).getUsuario().equals(txtUsuario.getText().toString())
            && Servicio.getInstance().getListaUsuarios().get(i).getConstraseña().equals(txtContraseña.getText().toString())){

                SharedPreferences preferences = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("idUsuario", Servicio.getInstance().getListaUsuarios().get(i).getId());
                editor.apply();
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