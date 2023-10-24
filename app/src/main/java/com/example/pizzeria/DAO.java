package com.example.pizzeria;

import java.lang.reflect.Array;
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

    public ArrayList<Usuario> getListaUsuarios(){
        listaUsuarios = new ArrayList<>();

        listaUsuarios.add(new Usuario(null,"Christian","Prado", "christian","christian"));
        listaUsuarios.add(new Usuario(null,"Cayetano","Linares", "cayetano","cayetano"));
        listaUsuarios.add(new Usuario(null,"Juan Carlos","Pérez", "juancarlos","juancarlos"));
        listaUsuarios.add(new Usuario(null,"Iván","Pérez", "ivan","ivan"));
        listaUsuarios.add(new Usuario(null,"Lucía","Pizarro", "lucia","lucia"));
        listaUsuarios.add(new Usuario(null,"Luis","Vázquez", "luis","luis"));
        listaUsuarios.add(new Usuario(null,"Pablo","Hernández", "pablo","pablo"));

        return listaUsuarios;

    }

    public ArrayList<Pizza> getListaPizzas(){
        listaPizzas = new ArrayList<>();

        listaPizzas.add(new Pizza("Margherita",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.ALBAHACA,TipoIngrediente.ACEITE_OLIVA},TipoTamano.FAMILIAR,13.50));
        listaPizzas.add(new Pizza("Marinara",4,new TipoIngrediente[]{TipoIngrediente.TOMATE_FRITO,TipoIngrediente.AJO,TipoIngrediente.ACEITE_OLIVA,TipoIngrediente.OREGANO},TipoTamano.MEDIANA,11.90));
        listaPizzas.add(new Pizza("Diavola",4,new TipoIngrediente[]{TipoIngrediente.SALSA_PICANTE,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.MOZZARELLA,TipoIngrediente.ACEITUNAS},TipoTamano.FAMILIAR,14.90));
        listaPizzas.add(new Pizza("Prosciutto E Funghi",4,new TipoIngrediente[]{TipoIngrediente.JAMON,TipoIngrediente.CHAMPIÑON,TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO},TipoTamano.FAMILIAR,14.50));
        listaPizzas.add(new Pizza("Del Bosco",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.CALABAZA,TipoIngrediente.TRUFA,TipoIngrediente.NATA},TipoTamano.FAMILIAR,18.90));
        listaPizzas.add(new Pizza("Capricciosa",7,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.ALCACHOFAS,TipoIngrediente.ACEITUNAS,TipoIngrediente.JAMON,TipoIngrediente.CHAMPIÑON,TipoIngrediente.ANCHOAS},TipoTamano.FAMILIAR,13.90));
        listaPizzas.add(new Pizza("Calzone",4,new TipoIngrediente[]{TipoIngrediente.TOMATE_FRITO,TipoIngrediente.MOZZARELLA,TipoIngrediente.SALSA_PICANTE,TipoIngrediente.JAMON},TipoTamano.MEDIANA,15.90));
        listaPizzas.add(new Pizza("QUATTRO FORMAGGI",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.ALBAHACA,TipoIngrediente.ACEITE_OLIVA},TipoTamano.FAMILIAR,13.50));
        listaPizzas.add(new Pizza("Margherita",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.ALBAHACA,TipoIngrediente.ACEITE_OLIVA},TipoTamano.FAMILIAR,13.50));
        listaPizzas.add(new Pizza("Margherita",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.ALBAHACA,TipoIngrediente.ACEITE_OLIVA},TipoTamano.FAMILIAR,13.50));
        listaPizzas.add(new Pizza("Margherita",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.ALBAHACA,TipoIngrediente.ACEITE_OLIVA},TipoTamano.FAMILIAR,13.50));
        listaPizzas.add(new Pizza("Margherita",4,new TipoIngrediente[]{TipoIngrediente.MOZZARELLA,TipoIngrediente.TOMATE_FRITO,TipoIngrediente.ALBAHACA,TipoIngrediente.ACEITE_OLIVA},TipoTamano.FAMILIAR,13.50));
    }



}