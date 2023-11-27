package com.example.pizzeria;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario {

    private int id = 0;
    private String nombre;
    private String apellido;
    private String usuario;
    private String constraseña;

    private ArrayList<Pizza> listaPizzasFavoritas;

    public Usuario(int id, String nombre, String apellido, String usuario, String constraseña, ArrayList<Pizza> listaPizzasFavoritas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.constraseña = constraseña;
        this.listaPizzasFavoritas = listaPizzasFavoritas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Pizza> getListaPizzasFavoritas() {
        return listaPizzasFavoritas;
    }

    public void setListaPizzasFavoritas(ArrayList<Pizza> listaPizzasFavoritas) {
        this.listaPizzasFavoritas = listaPizzasFavoritas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getConstraseña() {
        return constraseña;
    }

    public void setConstraseña(String constraseña) {
        this.constraseña = constraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "IdUsuario=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", usuario='" + usuario + '\'' +
                ", constraseña='" + constraseña + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
