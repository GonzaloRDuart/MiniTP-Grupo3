package com.utn.frba.relacionamientopersonas.controller;


import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import com.utn.frba.relacionamientopersonas.service.apiServices.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;

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

}