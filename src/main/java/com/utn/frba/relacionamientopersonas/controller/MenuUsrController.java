package com.utn.frba.relacionamientopersonas.controller;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import com.utn.frba.relacionamientopersonas.model.usuario.UsuarioEstandar;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuUsrController {

    private final Handlebars handlebars = new Handlebars();

    @GetMapping(value = "/estadoDelegacion", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> estadoDelegacion() throws IOException {

        //Provisorio hasta poder obtener el usuario de la sesion
        UsuarioEstandar usuario = new UsuarioEstandar(new Persona());
        usuario.setNombre("usuarioEnviando");
        UsuarioEstandar usuarioAEnviar = new UsuarioEstandar(new Persona());
        usuarioAEnviar.setNombre("usuarioAEnviar");
        usuario.enviarDelegacion(usuarioAEnviar);
        //cambiar arriba
        Template template = handlebars.compile("/templates/estadoDelegacion");
        List<Delegacion> delegaciones = usuario.getDelegaciones();
        Map<String, Object> modelo = new HashMap<>();
        modelo.put("delegaciones", delegaciones);

        String html = template.apply(modelo);

        return ResponseEntity.status(200).body(html);

    }

    @GetMapping({"/actualizarDatos"})
    public String actualizarDatos(){return "actualizarDatos";}

    @GetMapping({"/autorizacion"})
    public String autorizacion(){return "autorizacion";}

    @GetMapping({"/solicitudes"})
    public String solicitudes(){return "solicitudes";}
}
