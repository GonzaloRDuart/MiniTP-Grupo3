package com.utn.frba.relacionamientopersonas.service.utils;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioDelegaciones;
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioPersonas;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GenerarReporteService {

    static JsonFactory factory = new JsonFactory();

    static GenerarReporteService instance;

    public GenerarReporteService(){
        this.factory = new JsonFactory();
    }

    public static GenerarReporteService getInstance(){
        if(instance == null) return new GenerarReporteService();
        else return instance;
    }

    public static String generarReportePersonas() throws IOException {
        return new String(Files.readAllBytes(Paths.get("personas.json")));
    }

    public static String generarReporteDelegaciones() throws IOException {
        if(RepositorioDelegaciones.getInstance().getActualizar()){
            JsonGenerator generator = factory.createGenerator(
                    new File("reporteDelegaciones.json"), JsonEncoding.UTF8);

            generator.writeStartObject();
            generator.writeStringField("titulo", "Listado de Delegaciones");
            generator.writeFieldName("delegaciones");
            generator.writeStartArray();
            RepositorioDelegaciones.getInstance().getDelegaciones().forEach(delegacion -> {
                try {
                    generator.writeStartObject();
                    generator.writeStringField("autorizante", delegacion.getAutorizante().getPersona().getNombre());
                    generator.writeStringField("autorizado", delegacion.getAutorizado().getPersona().getNombre());
                    generator.writeStringField("estado", delegacion.getEstado().toString());
                    generator.writeEndObject();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            generator.writeEndArray();
            generator.writeEndObject();
            generator.close();
        }
        return new String(Files.readAllBytes(Paths.get("reporteDelegaciones.json")));
    }

}
