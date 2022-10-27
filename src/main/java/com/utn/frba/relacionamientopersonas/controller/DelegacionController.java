package com.utn.frba.relacionamientopersonas.controller;

import com.github.jknack.handlebars.Template;
import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioDelegaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.github.jknack.handlebars.Handlebars;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DelegacionController {

  private final RepositorioDelegaciones repoDelegaciones;
  private final Handlebars handlebars;

  public DelegacionController() {
      this.repoDelegaciones = new RepositorioDelegaciones();
      this.handlebars = new Handlebars();

  }

    @GetMapping(value = "/delegaciones", produces = MediaType.TEXT_HTML) //Evaular si cambiarlo a TEXT_HTML_TYPE
    public ResponseEntity<String> obtenerVistaDeTodas(@RequestParam("sesion") String idSesion) throws IOException {
      Template template = handlebars.compile("/templates/index");
      List<Delegacion> delegaciones = repoDelegaciones.getDelegaciones();

      Map<String, Object> model = new HashMap<>();
      model.put("listadelegaciones", delegaciones);

      String html = template.apply(model);

      return ResponseEntity.status(200).body(html);
  }

  /*
    @Autowired
    private IDelegacionService interfazDelegacion;

    @GetMapping("/delegacion")
    public List<Delegacion> getDelegacion() {return interfazDelegacion.getDelegacion();}

    @DeleteMapping("delegacion/eliminar/{id}")
    public String deleteDelegacion(@PathVariable Integer id) {
        interfazDelegacion.deleteDelegacion(id);
        return "La delegacion fue eliminada correctamente";
    }

    @PostMapping("/delegacion/crear")
    public String saveDelegacion(@RequestBody Delegacion delegacion) {
        interfazDelegacion.saveDelegacion(delegacion);
        return "La delegacion fue creada correctamente";
    }
*/
}
