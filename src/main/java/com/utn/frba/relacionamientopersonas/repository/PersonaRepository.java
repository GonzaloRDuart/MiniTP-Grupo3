package com.utn.frba.relacionamientopersonas.repository;

import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {
}
