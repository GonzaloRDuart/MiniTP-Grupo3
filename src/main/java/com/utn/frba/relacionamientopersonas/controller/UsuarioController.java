package com.utn.frba.relacionamientopersonas.controller;


import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
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

    @PostMapping("/validacion/post")
    public String validarDatosUsuario(@PathVariable String dni, @PathVariable String nombre, @PathVariable String apellido) throws FileNotFoundException {
        if(usuarioServicio.validarDatosUsuario(dni, nombre, apellido).getStatusCode().toString()=="201") return "redirect:/registrarse";
        //o pantalla de error
        else return "error";
    }

}