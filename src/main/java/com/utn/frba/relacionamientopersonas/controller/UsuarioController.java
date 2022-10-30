package com.utn.frba.relacionamientopersonas.controller;


import com.github.jknack.handlebars.internal.lang3.ObjectUtils;
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioPersonas;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import com.utn.frba.relacionamientopersonas.service.apiServices.PersonaService;
import com.utn.frba.relacionamientopersonas.service.apiServices.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;

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
        return "redirect:/index?exito=true";
    }

    @PostMapping("/actualizarDatos")
    public void actualizarDatos(){
        //Aca debería ir la persona del usuario
        Persona persona = new Persona();
        persona.setFechaNacimiento(null);
        persona.setCiudad(null);
        persona.setLocalidad(null);
        persona.setFoto(null);
        //Aca iría el id de la persona del usuario
        RepositorioPersonas.getInstance().deletePersona(persona);
        personaService.deletePersona(0);
        RepositorioPersonas.getInstance().addPersonas(persona);
        personaService.savePersona(persona);
        //usario.setPersona(persona);
    }

    @PostMapping("/autorizacion")
    public void autorizacion(String nombreUsuario){
        /* Generar Repositorio usuarios
        RepositorioUsuarios repoUsuarios = RepositorioUsuarios.getInstance()
        if(repoUsuarios.getUsuarios().any(usuario -> ususario.nombre() == nombreUsuario)){
            usuarioEnSesionAct.enviarDelegacion(repoUsuarios.getUsuarios.find(usuario -> usuario.nombre() = nombreUsuario);
        }
        else error usuario no encontrado*/
    }

}