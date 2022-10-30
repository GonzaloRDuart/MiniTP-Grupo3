package com.utn.frba.relacionamientopersonas.repository;

import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer> {
}
