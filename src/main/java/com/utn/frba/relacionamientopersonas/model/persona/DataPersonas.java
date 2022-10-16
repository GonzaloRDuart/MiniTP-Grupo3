package com.utn.frba.relacionamientopersonas.model.persona;
/*
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioPersonas;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DataPersonas {

    private String baseDeDatos;

    private static DataPersonas instance;

    RepositorioPersonas r = RepositorioPersonas.getInstance();
    public static DataPersonas getInstance(){
        if(instance == null) instance = new DataPersonas();
        return instance;
    }

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(String baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public void actualizarPersona(){
    }

    public void actualizarUsuario(){}

    public void crearPersona() {
        JSONParser jsonParser;
        jsonParser = new JSONParser();


        try (FileReader reader = new FileReader("personas.json")) {

            Object obj = jsonParser.parse(reader);

            JSONArray personasList = (JSONArray) obj;
            System.out.println(personasList);


            personasList.forEach(emp -> parsePersonasObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void parsePersonasObject(JSONObject persona) {

        ArrayList<Persona> per = new ArrayList<>();
        JSONObject personaObject = (JSONObject) persona.get("persona");

        String dni = (String) personaObject.get("dni");

        String nombre = (String) personaObject.get("nombre");

        String apellido = (String) personaObject.get("apellido");

        LocalDate fechaNacimiento = LocalDate.parse((String) personaObject.get("fechaNacimiento"));

        String ciudad = (String) personaObject.get("ciudad");

        String localidad = (String) personaObject.get("localidad");

        String foto = (String) personaObject.get("foto");

        Persona p = new Persona(dni,nombre,apellido,fechaNacimiento,ciudad,localidad,foto);

        r.addPersonas(p);

    }


}*/
