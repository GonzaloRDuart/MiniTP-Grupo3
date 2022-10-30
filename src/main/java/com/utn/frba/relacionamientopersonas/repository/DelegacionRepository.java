package com.utn.frba.relacionamientopersonas.repository;

import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelegacionRepository extends JpaRepository<Delegacion,Integer> {
}
