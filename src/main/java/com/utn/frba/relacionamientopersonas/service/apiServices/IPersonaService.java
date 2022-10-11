package com.utn.frba.relacionamientopersonas.service.apiServices;

import com.utn.frba.relacionamientopersonas.model.persona.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersona();

    public void savePersona(Persona persona);

    public void deletePersona(Integer id);

    public Persona findPersona(Integer id);
}
