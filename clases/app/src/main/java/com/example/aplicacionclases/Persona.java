package com.example.aplicacionclases;

public class Persona {
    private String nombre;
    private String apellido;
    private String rut;
    private String genero;
    private int edad;
    private String deporteFavorito;



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

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDeporteFavorito() {
        return deporteFavorito;
    }

    public void setDeporteFavorito(String deporteFavorito) {
        this.deporteFavorito = deporteFavorito;
    }

    @Override
    public String toString() {
        return "nombre= " + nombre + ' ' +
                ", rut= " + rut + ' ' +
                ", edad= " + edad + ' ' +
                ", deporteFavorito=" + deporteFavorito + '\'';
    }
}