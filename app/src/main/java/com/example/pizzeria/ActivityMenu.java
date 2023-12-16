package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ActivityMenu extends AppCompatActivity {
    ProgressDialog progressDialog;
    Task task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        progressDialog = new ProgressDialog(this);


    }

    public void finalizarActividad(View view){
        finish();
    }

    public void cambiarActividadCarta(View view){
        task = new Task(this);
        task.execute();


    }

    public void irAPaginaWeb(View view){
        String url = "https://marruzella.es/index.php/home";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        startActivity(intent);
    }

    public void enseñarProceso(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void aumentarProgreso(Integer valor){
        progressDialog.setProgress(valor);
    }

    public void borrarVentana(){
        progressDialog.dismiss();
    }

    public void comenzarActividad(){
        Intent intent = new Intent(this, ActivityCarta.class);
        startActivity(intent);
    }

}