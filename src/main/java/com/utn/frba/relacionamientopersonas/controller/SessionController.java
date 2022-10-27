package com.utn.frba.relacionamientopersonas.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
// Este controller lo genero para el manejo de sesiones
public class SessionController {
    private static SessionController instancia;

    private Map<String, Map<String, Object>> sesiones;

    private SessionController() {
        this.sesiones = new HashMap<>();
    }

    public static SessionController get() {
        if (instancia == null) {
            instancia = new SessionController();
        }
        return instancia;
    }

    public String crear() {
        return this.crear(new HashMap<>());
    }

    public String crear(String clave, Object valor) {
        HashMap<String, Object> atributo = new HashMap<>();
        atributo.put(clave, valor);
        return this.crear(atributo);
    }

    public String crear(Map<String, Object> atributos) {
        String id = UUID.randomUUID().toString();
        this.sesiones.put(id, atributos);
        return id;
    }

    public Map<String, Object> obtenerAtributos(String id) {
        return this.sesiones.get(id);
    }

    public void agregarAtributo(String id, String clave, Object valor) {
        Map<String, Object> atributos = this.sesiones.get(id);
        atributos.put(clave, valor);
    }

    public void agregarAtributos(String id, Map<String, Object> nuevosAtributos) {
        Map<String, Object> atributos = this.sesiones.get(id);
        atributos.putAll(nuevosAtributos);
    }

    public Map<String, Object> eliminar(String id) {
        //esto no elimina la cookie del frontend
        return this.sesiones.remove(id);
    }
}
