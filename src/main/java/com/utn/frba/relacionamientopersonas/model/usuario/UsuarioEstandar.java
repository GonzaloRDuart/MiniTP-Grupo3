package com.utn.frba.relacionamientopersonas.model.usuario;

import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import com.utn.frba.relacionamientopersonas.model.delegacion.Estado;

import java.util.List;

public class UsuarioEstandar extends Usuario{
    List<Delegacion> delegaciones;

    public void aceptarDelegacion(Delegacion delegacion) {
       delegacion.actualizarEstado(Estado.ACEPTADA);
       delegaciones.add(delegacion);
    }
    public void rechazarDelegacion(Delegacion delegacion) {
        delegacion.actualizarEstado(Estado.RECHZADA);
    }

    public void enviarDelegacion(Delegacion delegacion, Usuario usuario) {
        //TODO
    }

}
