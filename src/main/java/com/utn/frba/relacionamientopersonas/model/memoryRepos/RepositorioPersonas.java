package com.utn.frba.relacionamientopersonas.model.memoryRepos;

import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;

import java.util.List;

public class RepositorioPersonas {

    private List<Persona> personas;

    private static RepositorioPersonas instance;

    public static RepositorioPersonas getInstance(){
        if(instance == null) instance = new RepositorioPersonas();
        return instance;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void addPersonas(Persona persona){
        this.personas.add(persona);
    }
}
