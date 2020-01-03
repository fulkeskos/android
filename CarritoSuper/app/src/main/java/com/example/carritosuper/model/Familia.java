package com.example.carritosuper.model;

import java.util.Random;

public class Familia {
    private String codigo;
    private String nombre;

    public Familia() {
    }

    public Familia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String generarCodigo(){
        /*Random numeroRandom = new Random();
        int codigo;
        codigo = Math.abs(numeroRandom.nextInt() % 10000);
        return codigo;*/
        Random random = new Random();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        String codes = "";
        int m=0, pos=0,num;
        while(m<1){
            pos=(int)(random.nextDouble() * abc.length() -1 +0);
            num =(int)(random.nextDouble() * 9999 + 1000);
            code = code+abc.charAt(pos)+ num;
            pos = (int)(random.nextDouble() * abc.length()-1 +0);
            code = code + abc.charAt(pos);
            codes = code;
            code = "";
            m++;
        }
        return codes;
    }

    @Override
    public String toString() {

        return ""+codigo+";"+nombre+";";
    }
}
