package com.utn.frba.relacionamientopersonas.controller;


import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import com.utn.frba.relacionamientopersonas.service.apiServices.PersonaService;
import com.utn.frba.relacionamientopersonas.service.apiServices.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioServicio;
    @Autowired
    private PersonaService personaService;

    @ModelAttribute("usuario")
    public Usuario retornarNuevoUsuarioRegistroDTO() {
        return new Usuario();
    }

    @ModelAttribute("persona")
    public Persona retornarNuevaPersona() {
        return new Persona();
    }
/*
    @GetMapping("/registrarse")
    public String mostrarFormularioDeRegistro() {
        return "registrarse";
    }*/

    @PostMapping("/registrarse")
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioServicio.saveUsuario(usuario);
        return "redirect:/registrarse?exito";
    }

    @PostMapping("/validacion")
    public String validarDatosUsuario(@ModelAttribute("persona") Persona persona) {
        if(persona.getNombre().equals("Pablo") && persona.getApellido().equals("Ortiz") &&
        persona.getDni().equals("123456"))
            return "redirect:/registrarse";
        return "redirect:/index";


    }

}