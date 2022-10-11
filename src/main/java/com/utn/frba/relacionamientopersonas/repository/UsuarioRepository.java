package com.utn.frba.relacionamientopersonas.repository;

import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
