package com.example.carritosuper.model;

import java.util.ArrayList;
import java.util.List;

public class ObjetoCarro {
    private int id;
    private String nombreObjeto;
    private int estado;
    private int id_carro_fk;

    public ObjetoCarro(int id, String nombreObjeto, int estado, int id_carro_fk) {
        this.id = id;
        this.nombreObjeto = nombreObjeto;
        this.estado = estado;
        this.id_carro_fk = id_carro_fk;
    }

    public ObjetoCarro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId_carro_fk() {
        return id_carro_fk;
    }

    public void setId_carro_fk(int id_carro_fk) {
        this.id_carro_fk = id_carro_fk;
    }

    public List splitNombreObjeto(String cadenaASplitear) {

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
        return id + ";" + nombreObjeto + ";" + estado + ";" + id_carro_fk;
    }


}
