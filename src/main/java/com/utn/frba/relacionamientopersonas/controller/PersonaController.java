package com.utn.frba.relacionamientopersonas.controller;

import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.service.apiServices.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService intefazPersona;

    @GetMapping("/persona")
    public List<Persona> getPersona() {return intefazPersona.getPersona();}

    @DeleteMapping("persona/eliminar/{id}")
    public String deletePersona(@PathVariable Integer id) {
        intefazPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PostMapping("/persona/crear")
        public String savePersona(@RequestBody Persona persona) {
            intefazPersona.savePersona(persona);
            return "La persona fue creada correctamente";
        }
    }

