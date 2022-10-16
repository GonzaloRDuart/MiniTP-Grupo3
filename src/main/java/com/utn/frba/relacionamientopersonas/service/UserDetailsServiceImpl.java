package com.utn.frba.relacionamientopersonas.service;


import com.utn.frba.relacionamientopersonas.model.rol.Rol;
import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import com.utn.frba.relacionamientopersonas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepository userRepository;

 /*   @Autowired
    BCryptPasswordEncoder passwordEncoder;


    public Usuario guardar(Usuario usuario) {
        Usuario usuarioGuardar = new Usuario(usuario.getNombreUsuario(),
                passwordEncoder.encode(usuario.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
        return userRepository.save(usuario);
    }*/



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Buscar el usuario con el repositorio y si no existe lanzar una exepcion
        Usuario appUser = userRepository.findByNombreUsuario(username);
        if (appUser==null){
            throw new UsernameNotFoundException("no existe");
        }
        //Mapear nuestra lista de Authority con la de spring security
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        grantList.add(new SimpleGrantedAuthority("ROLE_USER"));
        //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
        return (UserDetails) new User (appUser.getNombreUsuario(), appUser.getPassword(), grantList);

    }
}