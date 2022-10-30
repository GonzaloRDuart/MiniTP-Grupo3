package com.utn.frba.relacionamientopersonas.model.memoryRepos;

import com.utn.frba.relacionamientopersonas.controller.PersonaController;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {

    private Boolean actualizar;

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    private static RepositorioUsuarios instance;

    public static RepositorioUsuarios getInstance(){
        if(instance == null) instance = new RepositorioUsuarios();
        return instance;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void addUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public void deletePersona(Usuario usuario){
        if(usuarios.contains(usuario)) usuarios.remove(usuarios.indexOf(usuario));
    }

    public Boolean getActualizar() {
        return actualizar;
    }

    public void setActualizar(Boolean actualizar) {
        this.actualizar = actualizar;
    }

}
