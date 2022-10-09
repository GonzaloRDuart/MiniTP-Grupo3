package com.utn.frba.relacionamientopersonas.model.usuario;

import com.utn.frba.relacionamientopersonas.service.utils.GenerarReporteService;

public class UsuarioAdmin extends Usuario{

    public String generarReportePersonas(){
        return GenerarReporteService.generarReportePersonas();
    }

    public String generarReporteDelegaciones(){
        return GenerarReporteService.generarReporteDelegaciones();
    }
}
