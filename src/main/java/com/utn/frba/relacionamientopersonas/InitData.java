package com.utn.frba.relacionamientopersonas;

import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import com.utn.frba.relacionamientopersonas.repository.UsuarioRepository;
import com.utn.frba.relacionamientopersonas.service.apiServices.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        Usuario usuario = new Usuario("pablo","123");
        usuarioService.saveUsuario(usuario);
    }
}
