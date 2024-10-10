package com.example.tp2_lab3.models;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String dni, nombre, apellido, email, contrasena;

    public Usuario(String dni, String nombre, String apellido, String email, String contrasena) {
        this.dni = dni;
        this.contrasena = contrasena;
        this.email = email;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Usuario() {

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
