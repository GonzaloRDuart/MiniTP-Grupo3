package com.utn.frba.relacionamientopersonas.controller;


import com.github.jknack.handlebars.internal.lang3.ObjectUtils;
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

    @ModelAttribute("usuario")
    public Usuario retornarNuevoUsuarioRegistroDTO() {
        return new Usuario();
    }


    @GetMapping("/registrarse/")
    public String mostrarFormularioDeRegistro() {
        return "registrarse";
    }

    @PostMapping("/registrarse")
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") Usuario usuario) {
        if(usuarioServicio.findUsuarioByName(usuario.getNombre())==true){
            return "redirect:/registrarse?error=true";
        }
        usuarioServicio.saveUsuario(usuario);
        return "redirect:/registrarse?exito=true";
    }



}