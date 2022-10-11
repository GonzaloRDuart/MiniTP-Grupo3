package com.utn.frba.relacionamientopersonas.model.memoryRepos;

import com.utn.frba.relacionamientopersonas.controller.DelegacionController;
import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepositorioDelegaciones {

    @Autowired
    DelegacionController delegaciondb;

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
