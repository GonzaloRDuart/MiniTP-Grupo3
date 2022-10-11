package com.utn.frba.relacionamientopersonas.model.delegacion;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Delegacion {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private String id;
    @Transient //Many To Many
    private Usuario autorizante;
    @Transient // Many To Many
    private Usuario autorizado;
    @Enumerated
    private Estado estado;

    public Usuario getAutorizante() {
        return autorizante;
    }

    public void setAutorizante(Usuario autorizante) {
        this.autorizante = autorizante;
    }

    public Usuario getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(Usuario autorizado) {
        this.autorizado = autorizado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void actualizarEstado(Estado estado) {
        this.estado = estado;
    }
}
