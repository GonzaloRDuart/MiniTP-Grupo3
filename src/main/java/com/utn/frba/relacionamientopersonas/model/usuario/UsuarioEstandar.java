package com.utn.frba.relacionamientopersonas.model.usuario;

import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import com.utn.frba.relacionamientopersonas.model.delegacion.Estado;
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioDelegaciones;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.service.apiServices.DelegacionService;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UsuarioEstandar extends Usuario{

    @OneToMany
    List<Delegacion> delegaciones;

    public UsuarioEstandar(Persona persona) {
        this.setPersona(persona);
        this.delegaciones = new ArrayList<>();
    }

    public UsuarioEstandar() {

    }

    public void aceptarDelegacion(Delegacion delegacion) {
       delegacion.actualizarEstado(Estado.ACEPTADA);
       RepositorioDelegaciones.getInstance().setActualizar(true);
    }
    public void rechazarDelegacion(Delegacion delegacion) {
        delegacion.actualizarEstado(Estado.RECHZADA);
        RepositorioDelegaciones.getInstance().setActualizar(true);
    }

    public Delegacion enviarDelegacion(UsuarioEstandar usuario) {
        Delegacion nuevaDelegacion = new Delegacion(this, usuario, Estado.EN_ESPERA);
        RepositorioDelegaciones.getInstance().addDelegacion(nuevaDelegacion);
        RepositorioDelegaciones.getInstance().setActualizar(true);
        this.getDelegaciones().add(nuevaDelegacion);
        usuario.getDelegaciones().add(nuevaDelegacion);
        return nuevaDelegacion;
    }

    public List<Delegacion> getDelegaciones() {
        return delegaciones;
    }
}
