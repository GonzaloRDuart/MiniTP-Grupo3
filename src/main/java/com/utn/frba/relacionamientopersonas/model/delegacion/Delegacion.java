package com.utn.frba.relacionamientopersonas.model.delegacion;

import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;

public class Delegacion {

    private Usuario autorizante;

    private Usuario autorizado;

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
