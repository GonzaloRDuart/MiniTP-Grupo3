package com.utn.frba.relacionamientopersonas.service.utils;

import com.utn.frba.relacionamientopersonas.model.persona.DataPersonas;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;

public class RegistrarUsuarioService {

    private static RegistrarUsuarioService instance;

    private DataPersonas baseDeDatos;

    public static  RegistrarUsuarioService getInstance(){
        if(instance == null) instance = new RegistrarUsuarioService();
        return instance;
    }

    public Usuario registrarUsuario(Persona persona){
        return null;
    }
}
