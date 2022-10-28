package com.utn.frba.relacionamientopersonas.fileReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class JsonReader {

    public List<Persona> lecturaJson() {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<Persona> personas = null;
        try {
            personas = objectMapper.readValue(
                    new File("pablo.json"),
                    new TypeReference<List<Persona>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       return personas;
    }

}
