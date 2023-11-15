package com.example.pizzeria;


import java.util.ArrayList;

public class Servicio {

    private static Servicio servicio = null;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Pizza> listaPizzasFabricadas;
    private Servicio(){
        listaUsuarios = DAO.getInstance().getListaUsuarios();
        listaPizzasFabricadas = DAO.getInstance().getListaPizzas();
    }

    public static Servicio getInstance(){
        if (servicio == null){
            servicio = new Servicio();
        }

        return servicio;

    }


    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Pizza> getListaPizzasFabricadas() {
        return listaPizzasFabricadas;
    }

    public void setListaPizzasFabricadas(ArrayList<Pizza> listaPizzasFabricadas) {
        this.listaPizzasFabricadas = listaPizzasFabricadas;
    }
}
