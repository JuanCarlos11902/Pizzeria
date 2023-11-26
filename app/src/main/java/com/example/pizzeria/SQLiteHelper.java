package com.example.pizzeria;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        ArrayList<Pizza> listaPizzas = new ArrayList<>();
        Type tipoJSON = new TypeToken<TipoIngrediente[]>() {}.getType();
         listaPizzas.add(new Pizza(1,"Margherita",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.ALBAHACA,TipoIngrediente.ACEITE_OLIVA},TipoTamano.FAMILIAR,13.50));
        listaPizzas.add(new Pizza(2,"Marinara",4,new TipoIngrediente[]{TipoIngrediente.TOMATE_FRITO,TipoIngrediente.AJO,TipoIngrediente.ACEITE_OLIVA,TipoIngrediente.OREGANO},TipoTamano.MEDIANA,11.90));
        listaPizzas.add(new Pizza(3,"Diavola",4,new TipoIngrediente[]{TipoIngrediente.SALSA_PICANTE,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.MOZZARELLA,TipoIngrediente.ACEITUNAS},TipoTamano.FAMILIAR,14.90));
        listaPizzas.add(new Pizza(4,"Prosciutto E Funghi",4,new TipoIngrediente[]{TipoIngrediente.JAMON,TipoIngrediente.CHAMPIÑON,TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO},TipoTamano.FAMILIAR,14.50));
        listaPizzas.add(new Pizza(5,"Del Bosco",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.CALABAZA,TipoIngrediente.TRUFA,TipoIngrediente.NATA},TipoTamano.FAMILIAR,18.90));
        listaPizzas.add(new Pizza(6,"Capricciosa",7,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.ALCACHOFAS,TipoIngrediente.ACEITUNAS,TipoIngrediente.JAMON,TipoIngrediente.CHAMPIÑON,TipoIngrediente.ANCHOAS},TipoTamano.FAMILIAR,13.90));
        listaPizzas.add(new Pizza(7,"Calzone",4,new TipoIngrediente[]{TipoIngrediente.TOMATE_FRITO,TipoIngrediente.MOZZARELLA,TipoIngrediente.SALSA_PICANTE,TipoIngrediente.JAMON},TipoTamano.MEDIANA,15.90));
        listaPizzas.add(new Pizza(8,"QUATTRO FORMAGGI",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.PROVOLA,TipoIngrediente.PARMESANO,TipoIngrediente.GORGONZOLA},TipoTamano.MEDIANA,13.90));
        listaPizzas.add(new Pizza(9,"Bufalina",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.ALBAHACA,TipoIngrediente.JAMON_YORK},TipoTamano.FAMILIAR,14.50));
        listaPizzas.add(new Pizza(10,"Melanzine",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.BEICON,TipoIngrediente.PARMESANO},TipoTamano.FAMILIAR,13.90));
        listaPizzas.add(new Pizza(11,"Culatello",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.QUESO_RULO_DE_CABRA,TipoIngrediente.JAMON_YORK},TipoTamano.FAMILIAR,15.90));

        ContentValues[] valuesPizza = new ContentValues[11];

        for (int i = 0; i < listaPizzas.size(); i++) {
            String ingredientes = new Gson().toJson(listaPizzas.get(i).getIngredientes(),tipoJSON);
            String tamano = listaPizzas.get(i).getTamano().toString();
            valuesPizza[i] = crearPizza(listaPizzas.get(i).getIdPizza(),listaPizzas.get(i).getNombre(),listaPizzas.get(i).getNumeroIngredientes(),ingredientes,tamano,listaPizzas.get(i).getPrecio());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(
                "Drop Table if Exists Pizza"
        );

        db.execSQL(
                "Drop Table if Exists Usuario"
        );
    }

    public ContentValues crearPizza(int id,String nombre,int numeroIngredientes,String ingredientes,String tamano,double precio){
        ContentValues values = new ContentValues();

        values.put("id",id);
        values.put("nombre",nombre);
        values.put("numeroIngredientes",numeroIngredientes);
        values.put("ingredientes",ingredientes);
        values.put("tamaño",tamano);
        values.put("precio",precio);

        return values;
    }
}
