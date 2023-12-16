package com.example.pizzeria;

import android.os.AsyncTask;

import com.example.pizzeria.ActivityMenu;

public class Task extends AsyncTask<Void, Integer, Void> {

    ActivityMenu miActividad;

    public Task(ActivityMenu miActividad){
        this.miActividad = miActividad;

    }

    @Override
    public void onPreExecute(){
        miActividad.enseñarProceso();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        for (int i = 0; i < 100; i++) {
            publishProgress(i);

            try{
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        // Actualizar la barra de progreso en la ventana emergente
        miActividad.aumentarProgreso(values[0]);
    }

    @Override
    protected void onPostExecute(Void result) {
        // Cerrar la ventana emergente y abrir una nueva actividad
        miActividad.borrarVentana();
        miActividad.comenzarActividad();

    }
}
