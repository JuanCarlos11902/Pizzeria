package com.example.pizzeria;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DAO {

    private static DAO dao = null;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Pizza> listaPizzas;

    public static DAO getInstance(){
        if (dao == null){
            dao = new DAO();
        }

        return dao;
    }

    private void getDatosTablasUsuario(SQLiteHelper helper){
        SQLiteDatabase db = helper.getWritableDatabase();
        this.listaUsuarios = new ArrayList<>();

        if (db != null){
            Cursor cursor = db.rawQuery("Select * from Usuario", null);
            cursor.moveToFirst();
            Gson gson = new Gson();
            Type typeList1 = new TypeToken<ArrayList<Pizza>>() {}.getType();

            while(cursor.moveToNext()){
                int id = cursor.getInt(0);
                String nombre = cursor.getString(1);
                String apellido = cursor.getString(2);
                String usuario = cursor.getString(3);
                String contraseña = cursor.getString(4);
                ArrayList<Pizza> listaPizzasFavoritas = gson.fromJson(cursor.getString(5), typeList1);

                Usuario usuario1 = new Usuario(id,nombre,apellido,usuario,contraseña);
                usuario1.setListaPizzasFavoritas(listaPizzasFavoritas);

                this.listaUsuarios.add(usuario1);
            }
        }
    }

    private void getDatosTablasPizza(SQLiteHelper helper){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Pizza",null);
        cursor.moveToFirst();
        Type typeList1 = new TypeToken<TipoIngrediente[]>(){}.getType();
        Gson gson = new Gson();
        this.listaPizzas = new ArrayList<>();

        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            int numeroIngredientes = cursor.getInt(2);
            TipoIngrediente[] ingredientes = gson.fromJson(cursor.getString(3),typeList1);
            TipoTamano tamano = TipoTamano.valueOf(cursor.getString(4));
            double precio = cursor.getDouble(5);

            Pizza pizza = new Pizza(id,nombre,numeroIngredientes,ingredientes,tamano,precio);
            this.listaPizzas.add(pizza);
        }
    }

    public ArrayList<Usuario> getListaUsuarios(SQLiteHelper helper){
        getDatosTablasUsuario(helper);
        return listaUsuarios;

    }

    public ArrayList<Pizza> getListaPizzas(SQLiteHelper helper){
        getDatosTablasPizza(helper);
        return listaPizzas;

    }


}
