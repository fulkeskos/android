package com.example.carritosuper.model;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private String nombreCarro;
    private int codigoFamiliar;
    private int estado;

    public Carrito(String nombreCarro, int codigoFamiliar, int estado) {
        this.nombreCarro = nombreCarro;
        this.codigoFamiliar = codigoFamiliar;
        this.estado = estado;
    }

    public Carrito() {
    }

    public String getNombreCarro() {
        return nombreCarro;
    }

    public void setNombreCarro(String nombreCarro) {
        this.nombreCarro = nombreCarro;
    }

    public int getCodigoFamiliar() {
        return codigoFamiliar;
    }

    public void setCodigoFamiliar(int codigoFamiliar) {
        this.codigoFamiliar = codigoFamiliar;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    public List splitNombreCarro(String cadenaASplitear) {

        String[] split1 = cadenaASplitear.split(",");
        //System.out.println("largo: " + split1.length);
        List<String> li = new ArrayList<>();

        for (int i = 0; i < split1.length; i++) {
            //obtengo
            //System.out.println(split1[i]);
            String cadena = split1[i];
            String[] splot = cadena.split(";");
            for (int j = 0; j < 1; j++) {
                //seteo en la lista
                li.add(splot[j].substring(1));
            }
        }
        return li;
    }

    @Override
    public String toString() {
        return ""+nombreCarro +";"+codigoFamiliar+";"+estado;
    }

}
