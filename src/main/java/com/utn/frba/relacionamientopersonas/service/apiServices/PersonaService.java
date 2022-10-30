package com.utn.frba.relacionamientopersonas.service.apiServices;

import com.utn.frba.relacionamientopersonas.model.persona.DataPersonas;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaService implements IPersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private DataPersonas dataPersonas;
    @Override
    public List<Persona> getPersona() {
        List<Persona> listaPersona = personaRepository.findAll();
        return listaPersona;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Integer id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Integer id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        return persona;
    }
    public Boolean encontrarPersonaEnJson(Persona personaBuscada){
      return dataPersonas.encontrarPersonaEnJson2(personaBuscada);
    }
}
