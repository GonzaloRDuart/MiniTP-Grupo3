package com.utn.frba.relacionamientopersonas;

import com.utn.frba.relacionamientopersonas.controller.dto.UsuarioRegistro;
import com.utn.frba.relacionamientopersonas.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    public void run(String... args) throws Exception {

        UsuarioRegistro usuarioRegistro = new UsuarioRegistro("Pablo");
        userDetailsService.guardar(usuarioRegistro);
    }
}
