package com.utn.frba.relacionamientopersonas.controller;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioPersonas;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;

import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import com.utn.frba.relacionamientopersonas.service.apiServices.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonaController {

    @Autowired
    PersonaService personaService;

    private final RepositorioPersonas repoPersonas;
    private final Handlebars handlebars;

    public PersonaController() {
        this.repoPersonas = new RepositorioPersonas();
        this.handlebars = new Handlebars();
    }

    @ModelAttribute("persona")
    public Persona retornarNuevaPersona() {
        return new Persona();
    }

    @GetMapping(value = "/personas", produces = MediaType.TEXT_HTML)
    public ResponseEntity<String> obtenerVistaDeTodas(@RequestParam("sesion") String idSesion) throws IOException {

        //validar accion en capa modelo según roles o usuario asociados al idSesion
        Template template = handlebars.compile("/templates/index");
        List<Persona> personas = repoPersonas.getPersonas();

        Map<String, Object> model = new HashMap<>();
        model.put("listamascotas", personas);

        String html = template.apply(model);

        return ResponseEntity.status(200).body(html);
    }



  /*  @Autowired
    private IPersonaService intefazPersona;

    @GetMapping("/persona")
    public List<Persona> getPersona() {return intefazPersona.getPersona();}

    @DeleteMapping("persona/eliminar/{id}")
    public String deletePersona(@PathVariable Integer id) {
        intefazPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PostMapping("/persona/crear")
        public String savePersona(@RequestBody Persona persona) {
            intefazPersona.savePersona(persona);
            return "La persona fue creada correctamente";
        }*/

    @PostMapping("/validacion")
    public String validarDatosUsuario(@ModelAttribute("persona") Persona persona) {
        if(personaService.encontrarPersonaEnJson(persona)==true)
            return "redirect:/registrarse";
        return "redirect:/validacion?error=true";


    }
}

