package com.utn.frba.relacionamientopersonas.controller;


import com.utn.frba.relacionamientopersonas.controller.dto.UsuarioRegistro;
import com.utn.frba.relacionamientopersonas.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class UsuarioController {

    private UserDetailsServiceImpl usuarioServicio;

    public UsuarioController(UserDetailsServiceImpl usuarioServicio) {
        super();
        this.usuarioServicio = usuarioServicio;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistro retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistro();
    }

    /*@GetMapping("/registrarse")
    public String mostrarFormularioDeRegistro() {
        return "registrarse";
    }*/

    @PostMapping("/registrarse")
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistro registroDTO) {
        usuarioServicio.guardar(registroDTO);
        return "redirect:/registrarse?exito";
    }

}
