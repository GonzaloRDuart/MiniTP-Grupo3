package com.utn.frba.relacionamientopersonas.service.apiServices;

import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import java.util.List;

public interface IDelegacionService {
    public List<Delegacion> getDelegacion();

    public void saveDelegacion(Delegacion delegacion);

    public void deleteDelegacion(Integer id);

    public Delegacion findDelegacion(Integer id);
}
