package com.utn.frba.relacionamientopersonas.model.memoryRepos;

import com.utn.frba.relacionamientopersonas.controller.PersonaController;
import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RepositorioPersonas {

     @Autowired
    PersonaController personadb;

    private ArrayList<Persona> personas = new ArrayList<>();

    private static RepositorioPersonas instance;

    public static RepositorioPersonas getInstance(){
        if(instance == null) instance = new RepositorioPersonas();
        return instance;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public void addPersonas(Persona persona){
        this.personas.add(persona);
    }
}
