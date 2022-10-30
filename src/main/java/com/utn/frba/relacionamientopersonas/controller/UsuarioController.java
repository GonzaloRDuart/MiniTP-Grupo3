package com.utn.frba.relacionamientopersonas.controller;


import com.github.jknack.handlebars.internal.lang3.ObjectUtils;
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioPersonas;
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioUsuarios;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import com.utn.frba.relacionamientopersonas.model.usuario.UsuarioEstandar;
import com.utn.frba.relacionamientopersonas.service.apiServices.DelegacionService;
import com.utn.frba.relacionamientopersonas.service.apiServices.PersonaService;
import com.utn.frba.relacionamientopersonas.service.apiServices.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.stream.Collectors;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioServicio;

    @Autowired
    private DelegacionService delegacionService;

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
        //Reemplazar al poder encontrar el usuario en sesion
        UsuarioEstandar usuarioPrueba = new UsuarioEstandar(new Persona());
        usuarioPrueba.setNombre("usuarioPrueba");
        UsuarioEstandar usuarioEnSesionAct = new UsuarioEstandar(new Persona());
        usuarioEnSesionAct.setNombre("usuarioEnSesionAct");
        RepositorioUsuarios repoUsuarios = RepositorioUsuarios.getInstance();
        repoUsuarios.addUsuario(usuarioPrueba);
        usuarioServicio.saveUsuario(usuarioPrueba);
        usuarioServicio.saveUsuario(usuarioEnSesionAct);
        delegacionService.saveDelegacion(usuarioEnSesionAct.enviarDelegacion(usuarioPrueba));
        if(repoUsuarios.getUsuarios().stream().anyMatch(usuario -> usuario.getNombre() == nombreUsuario)){
            delegacionService.saveDelegacion(usuarioEnSesionAct.enviarDelegacion((UsuarioEstandar) repoUsuarios.getUsuarios().stream()
                    .filter(usuario -> usuario.getNombre() == nombreUsuario)
                    .collect(Collectors.toList())
                    .get(0)));
        }
        //else caso de error usuario no encontrado
    }

}