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
        
    }



}
