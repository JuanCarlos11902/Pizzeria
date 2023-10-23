package com.example.pizzeria;

import java.util.Objects;

public class Usuario {

    private static int IdUsuario = 0;
    private Pizza ultimoPedido;
    private String nombre;
    private String apellido;
    private String usuario;
    private String constraseña;

    public Usuario(Pizza ultimoPedido, String nombre, String apellido, String usuario, String constraseña) {
        this.IdUsuario++;
        this.ultimoPedido = ultimoPedido;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.constraseña = constraseña;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public Pizza getUltimoPedido() {
        return ultimoPedido;
    }

    public void setUltimoPedido(Pizza ultimoPedido) {
        this.ultimoPedido = ultimoPedido;
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
                "IdUsuario=" + IdUsuario +
                ", ultimoPedido=" + ultimoPedido +
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
        return IdUsuario == usuario.IdUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdUsuario);
    }
}
