package com.utn.frba.relacionamientopersonas.model.delegacion;

import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import com.utn.frba.relacionamientopersonas.model.usuario.UsuarioEstandar;

import javax.persistence.*;

@Entity
public class Delegacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Transient //Many To Many
    private UsuarioEstandar autorizante;
    @Transient // Many To Many
    private UsuarioEstandar autorizado;
    @Enumerated
    private Estado estado;

    public Delegacion(UsuarioEstandar autorizante, UsuarioEstandar autorizado, Estado estado){
        this.autorizante = autorizante;
        this.autorizado = autorizado;
        this.estado = estado;
    }

    public Delegacion(){}

    public Usuario getAutorizante() {
        return autorizante;
    }

    public void setAutorizante(UsuarioEstandar autorizante) {
        this.autorizante = autorizante;
    }

    public Usuario getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(UsuarioEstandar autorizado) {
        this.autorizado = autorizado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void actualizarEstado(Estado estado) {
        this.estado = estado;
    }

    public String toString() {
        return "Delegacion{" +
                    "id" + id +
                    ", autorizante='" + autorizante.getNombre() + '\'' +
                    ", autorizado='" + autorizado + '\'' +
                    ", estado='" + estado + '\'' +
                    '}';
        }

}
