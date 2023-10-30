package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void finalizarActividad(View view){
        finish();
    }

    public void cambiarActividadCarta(View view){

        Intent intent = new Intent(this, ActivityCarta.class);
        startActivity(intent);

    }

}