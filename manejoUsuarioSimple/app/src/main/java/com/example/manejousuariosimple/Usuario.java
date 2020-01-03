package com.example.manejousuariosimple;

public class Usuario {
    private String nombre;
    private String rut;
    private String swt;
    private String deporte;
    private String casado;
    private boolean sexo; // [TRUE: HOMBRE] - [FALSE: MUJER]

    public Usuario (String nom, String rut, String sw, String depor, String casado, boolean sex){
        this.nombre = nom;
        this.rut = rut;
        this.swt = sw;
        this.deporte = depor;
        this.casado = casado;
        this.sexo = sex;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nomm){
        this.nombre = nomm;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getSwt() {
        return swt;
    }

    public void setSwt(String swt) {
        this.swt = swt;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getCasado() {
        return casado;
    }

    public void setCasado(String casado) {
        this.casado = casado;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
}
