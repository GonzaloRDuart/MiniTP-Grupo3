package com.utn.frba.relacionamientopersonas.service.utils;

import com.utn.frba.relacionamientopersonas.model.persona.DataPersonas;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;

import java.io.FileNotFoundException;

public class RegistrarUsuarioService {

    private static RegistrarUsuarioService instance;

    private DataPersonas baseDeDatos;

    public static  RegistrarUsuarioService getInstance() throws FileNotFoundException {
        if(instance == null){
            instance = new RegistrarUsuarioService();
            instance.baseDeDatos = DataPersonas.getInstance();
        }
        return instance;
    }

    public Usuario registrarUsuario(Persona persona){
        return null;
    }

    public boolean validarDatosUsuario(String dni){
        return baseDeDatos.existeDNI(dni);
    }
}
