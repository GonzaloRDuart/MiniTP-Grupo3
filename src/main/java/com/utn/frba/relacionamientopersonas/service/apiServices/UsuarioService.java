package com.utn.frba.relacionamientopersonas.service.apiServices;

import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioPersonas;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.model.rol.Rol;
import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import com.utn.frba.relacionamientopersonas.repository.UsuarioRepository;
import com.utn.frba.relacionamientopersonas.service.utils.RegistrarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> getUsuario() {
        List<Usuario> listaUsuario = usuarioRepository.findAll();
        return listaUsuario;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        Usuario usuarioGuardar = new Usuario(usuario.getNombre(),
               usuario.getPassword(), Arrays.asList(new Rol("ROLE_USER")));
        usuarioRepository.save(usuarioGuardar);
    }

    @Override
    public void deleteUsuario(Integer id) {usuarioRepository.deleteById(id);}

    @Override
    public Usuario findUsuario(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
      //Buscar el usuario con el repositorio y si no existe lanzar una exepcion
        Usuario appUser = usuarioRepository.findByNombre(nombre);
        if (appUser==null){
            throw new UsernameNotFoundException("no existe");
        }
        //Mapear nuestra lista de Authority con la de spring security
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        grantList.add(new SimpleGrantedAuthority("ROLE_USER"));
        //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
        //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
        return (UserDetails) new User(appUser.getNombre(), appUser.getPassword(), grantList);
    }

    public ResponseEntity validarDatosUsuario(String dni, String nombre, String apellido) throws FileNotFoundException {
        if(RegistrarUsuarioService.getInstance().validarDatosUsuario(dni)){
            Persona nuevaPersona = new Persona(dni, nombre, apellido);
            RepositorioPersonas.getInstance().addPersonas(nuevaPersona);
            return ResponseEntity.status(201).body(nuevaPersona);
        }
        else return ResponseEntity.status(400).body(null);
    }
}
