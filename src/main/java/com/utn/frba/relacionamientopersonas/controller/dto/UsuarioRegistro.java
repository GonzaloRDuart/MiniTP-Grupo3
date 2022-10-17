package com.utn.frba.relacionamientopersonas.controller.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioRegistro {


    private String nombre;


    public UsuarioRegistro(String nombre) {
        this.nombre = nombre;
    }

    public UsuarioRegistro() {

    }
}