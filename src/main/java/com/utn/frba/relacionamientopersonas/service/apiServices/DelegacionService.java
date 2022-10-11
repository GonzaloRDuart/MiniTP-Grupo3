package com.utn.frba.relacionamientopersonas.service.apiServices;

import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import com.utn.frba.relacionamientopersonas.repository.DelegacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DelegacionService implements IDelegacionService{

    @Autowired
    private DelegacionRepository delegacionRepository;
    @Override
    public List<Delegacion> getDelegacion() {
        List<Delegacion> listaDelegacion = delegacionRepository.findAll();
        return listaDelegacion;
    }

    @Override
    public void saveDelegacion(Delegacion delegacion) {
        delegacionRepository.save(delegacion);
    }

    @Override
    public void deleteDelegacion(Integer id) {
        delegacionRepository.deleteById(id);
    }

    @Override
    public Delegacion findDelegacion(Integer id) {
        Delegacion delegacion = delegacionRepository.findById(id).orElse(null);
        return delegacion;
    }
}
