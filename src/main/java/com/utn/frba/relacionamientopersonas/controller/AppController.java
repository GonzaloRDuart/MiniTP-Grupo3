package com.utn.frba.relacionamientopersonas.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"/","/index"})
    public String index() {
        return "index";
    }

    @GetMapping({"/iniciarSesion","/login"})
    public String iniciarSesion() {
        return "iniciarSesion";
    }

    @GetMapping({"/menuUsuario"})
    public String menuUsuario() {
        return "menuUsuario";
    }

    @GetMapping({"/registrarse"})
    public String registrarse() {
        return "registrarse";
    }

}