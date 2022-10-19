package com.utn.frba.relacionamientopersonas.service.apiServices;

import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUsuarioService extends UserDetailsService {

    public List<Usuario> getUsuario();
    public void saveUsuario(Usuario usuario);
    public void deleteUsuario(Integer id);
    public Usuario findUsuario(Integer id);
}
