package com.example.pizzeria;

import java.util.Arrays;
import java.util.Objects;

public class Pizza {

    private int idPizza = 0;
    private int numeroIngredientes;
    private TipoIngrediente[] ingredientes;
    private TipoTamano tamano;
    private double precio;


    public Pizza(int idPizza, int numeroIngredientes, TipoIngrediente[] ingredientes, TipoTamano tamano, double precio) {
        this.idPizza = idPizza;
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
