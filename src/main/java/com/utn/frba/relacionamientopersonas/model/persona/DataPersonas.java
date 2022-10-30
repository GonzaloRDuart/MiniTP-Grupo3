package com.utn.frba.relacionamientopersonas.model.persona;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioDelegaciones;
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioPersonas;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Getter @Setter
public class DataPersonas {

    private static String baseDeDatos;

    private static DataPersonas instance;

    RepositorioPersonas repositorioPersonas = RepositorioPersonas.getInstance();

    public List<Persona> lecturaJson() {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<Persona> personas = null;
        try {
            personas = objectMapper.readValue(
                    new File("personas.json"),
                    new TypeReference<List<Persona>>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return personas;
    }

    public Boolean encontrarPersonaEnJson(Persona personaBuscada) {
        List<Persona> personas = lecturaJson();
        return personas.stream().anyMatch(persona -> persona.getDni().equals(personaBuscada.getDni()));
    }

    //Revisar que conviene, a mi de la otra manera no me funcionó.
    public Boolean encontrarPersonaEnJson2(Persona personaBuscada) {
        File jsonFile = new File("baseDeDatos.json");
        Scanner myReader = null;
        String data = null;
        try {
            myReader = new Scanner(jsonFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (myReader.hasNextLine()) {
            data += myReader.nextLine();
        }
        return data.contains("\""+personaBuscada.getDni()+"\"");
    }
}
