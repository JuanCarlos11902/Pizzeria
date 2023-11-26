package com.example.pizzeria;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Pizza implements Serializable {

    private int idPizza = 0;
    private String nombre;
    private int numeroIngredientes;
    private TipoIngrediente[] ingredientes;
    private TipoTamano tamano;
    private double precio;


    public Pizza(int id,String nombre, int numeroIngredientes, TipoIngrediente[] ingredientes, TipoTamano tamano, double precio) {
        this.idPizza = id;
        this.nombre = nombre;
        this.numeroIngredientes = numeroIngredientes;
        this.ingredientes = ingredientes;
        this.tamano = tamano;
        this.precio = precio;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroIngredientes() {
        return numeroIngredientes;
    }

    public void setNumeroIngredientes(int numeroIngredientes) {
        this.numeroIngredientes = numeroIngredientes;
    }

    public TipoIngrediente[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(TipoIngrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public TipoTamano getTamano() {
        return tamano;
    }

    public void setTamano(TipoTamano tamano) {
        this.tamano = tamano;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "idPizza=" + idPizza +
                ", nombre='" + nombre + '\'' +
                ", numeroIngredientes=" + numeroIngredientes +
                ", ingredientes=" + Arrays.toString(ingredientes) +
                ", tamano=" + tamano +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return idPizza == pizza.idPizza;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPizza);
    }
}
