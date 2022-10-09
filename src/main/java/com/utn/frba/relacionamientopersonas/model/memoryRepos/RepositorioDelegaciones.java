package com.utn.frba.relacionamientopersonas.model.memoryRepos;

import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;

import java.util.List;

public class RepositorioDelegaciones {

    private List<Delegacion> delegaciones;
    private static RepositorioDelegaciones instance;

    public static RepositorioDelegaciones getInstance(){
        if(instance == null) instance = new RepositorioDelegaciones();
        return instance;
    }

    public List<Delegacion> getDelegaciones() {
        return delegaciones;
    }

    public void setDelegaciones(List<Delegacion> delegaciones) {
        this.delegaciones = delegaciones;
    }

    public void addDelegacion(Delegacion delegacion){
        this.delegaciones.add(delegacion);
    }
}
