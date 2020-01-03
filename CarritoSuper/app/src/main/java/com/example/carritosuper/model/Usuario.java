package com.example.carritosuper.model;

public class Usuario {
    private String nombre;
    private String apellido;
    private String passwd;
    private String codF;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String passwd, String codFa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.passwd = passwd;
        this.codF = codFa;
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getCodF() {
        return codF;
    }

    public void setCodF(String codF) {
        this.codF = codF;
    }

    public String[] splitUsuario(String cadena) {
        String[] partes = cadena.split(";");

        return partes;

    }
    @Override
    public String toString() {
        return ""+nombre+";"+apellido+";"+passwd+";"+codF+"";
    }
}
