package com.utn.frba.relacionamientopersonas.model.memoryRepos;

import com.utn.frba.relacionamientopersonas.controller.DelegacionController;
import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import com.utn.frba.relacionamientopersonas.service.apiServices.DelegacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepositorioDelegaciones {
    @Autowired
    private DelegacionService delegaciondb;

    private Boolean actualizar;
    private List<Delegacion> delegaciones;
    private static RepositorioDelegaciones instance;

    public static RepositorioDelegaciones getInstance(){
        if(instance == null) instance = new RepositorioDelegaciones();
        return instance;
    }

    public RepositorioDelegaciones(){
        this.delegaciones = new ArrayList<>();
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

    public Boolean getActualizar() {
        return actualizar;
    }

    public void setActualizar(Boolean actualizar) {
        this.actualizar = actualizar;
    }
}