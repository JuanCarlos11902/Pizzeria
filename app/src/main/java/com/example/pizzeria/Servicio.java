package com.example.pizzeria;


import java.util.ArrayList;

public class Servicio {

    DAO dao = DAO.getInstance();

    private ArrayList<Usuario> listaUsuarios = dao.getListaUsuarios();
    private ArrayList<Pizza> listaPizzasFabricadas = dao.getListaPizzas();

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
