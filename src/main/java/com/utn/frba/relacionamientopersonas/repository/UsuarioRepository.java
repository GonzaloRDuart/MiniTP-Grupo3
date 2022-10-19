package com.utn.frba.relacionamientopersonas.repository;

import java.util.Optional;

import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    public Usuario findByNombre(String nombreUsuario);
}
