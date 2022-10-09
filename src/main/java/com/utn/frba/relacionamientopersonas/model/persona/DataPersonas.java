package com.utn.frba.relacionamientopersonas.model.persona;

import javax.xml.crypto.Data;

public class DataPersonas {

    private String baseDeDatos;

    private DataPersonas instance;

    public DataPersonas getInstance(){
        if(instance == null) instance = new DataPersonas();
        return this.instance;
    }

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(String baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public Persona crearPersona(){
        return null;
    }

    public void actualizarPersona(){
    }

    public void actualizarUsuario(){}
}
