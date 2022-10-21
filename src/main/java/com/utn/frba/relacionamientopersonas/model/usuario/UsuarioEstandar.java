package com.utn.frba.relacionamientopersonas.model.usuario;

import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import com.utn.frba.relacionamientopersonas.model.delegacion.Estado;
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioDelegaciones;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.service.apiServices.DelegacionService;

import java.util.ArrayList;
import java.util.List;

public class UsuarioEstandar extends Usuario{
    List<Delegacion> delegaciones;

    public UsuarioEstandar(Persona persona) {
        this.setPersona(persona);
        this.delegaciones = new ArrayList<>();
    }

    public void aceptarDelegacion(Delegacion delegacion) {
       delegacion.actualizarEstado(Estado.ACEPTADA);
       RepositorioDelegaciones.getInstance().setActualizar(true);
    }
    public void rechazarDelegacion(Delegacion delegacion) {
        delegacion.actualizarEstado(Estado.RECHZADA);
        RepositorioDelegaciones.getInstance().setActualizar(true);
    }

    public void enviarDelegacion(UsuarioEstandar usuario) {
        Delegacion nuevaDelegacion = new Delegacion(this, usuario, Estado.EN_ESPERA);
        RepositorioDelegaciones.getInstance().addDelegacion(nuevaDelegacion);
        RepositorioDelegaciones.getInstance().setActualizar(true);
        usuario.getDelegaciones().add(nuevaDelegacion);
    }

    public List<Delegacion> getDelegaciones() {
        return delegaciones;
    }
}
