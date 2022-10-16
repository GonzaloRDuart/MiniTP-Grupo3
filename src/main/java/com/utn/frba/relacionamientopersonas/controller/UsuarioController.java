package com.utn.frba.relacionamientopersonas.controller;

import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UsuarioController {
  /*  @Autowired
    private IUsuarioService interfazUsuario;

    @GetMapping("/usuario")
    public List<Usuario> getUsuario(){return interfazUsuario.getUsuario();}

    @DeleteMapping("usuario/eliminar/{id}")
    public String deleteUsuario(@PathVariable Integer id) {
        interfazUsuario.deleteUsuario(id);
        return "El usuario fue eliminado correctamente";
    }

    @PostMapping("/usuario/crear")
    public String saveUsuario(@RequestBody Usuario usuario) {
        interfazUsuario.saveUsuario(usuario);
        return "El usuario fue creado correctamente";
    }
*/

}
