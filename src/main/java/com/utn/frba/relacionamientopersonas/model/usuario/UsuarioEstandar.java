package com.utn.frba.relacionamientopersonas.model.usuario;

import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import com.utn.frba.relacionamientopersonas.model.delegacion.Estado;
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioDelegaciones;

import java.util.List;

public class UsuarioEstandar extends Usuario{

    private List<Delegacion> delegaciones;

    public List<Delegacion> getDelegaciones() {
        return delegaciones;
    }
    public void addDelegacion(Delegacion delegacion){
        this.delegaciones.add(delegacion);
    }

    public void aceptarDelegacion(Delegacion delegacion){
        delegacion.actualizarEstado(Estado.ACEPTADA);
        //Falta actualizar en repoMemoriayBD
    }

    public void rechazarDelegacion(Delegacion delegacion){
        delegacion.actualizarEstado(Estado.RECHZADA);
        //falta actualizar en repoMemoriaYBD
    }

    public void enviarDelegacion(Delegacion delegacion, UsuarioEstandar usuario){
        delegacion.actualizarEstado(Estado.EN_ESPERA);
        usuario.addDelegacion(delegacion);
        RepositorioDelegaciones.getInstance().addDelegacion(delegacion);
    }
}
