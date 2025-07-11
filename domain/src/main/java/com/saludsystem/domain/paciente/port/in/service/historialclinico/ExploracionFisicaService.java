package com.saludsystem.domain.paciente.port.in.service.historialclinico;

import com.saludsystem.application.dto.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.application.dto.post.historialclinico.CrearExploracionFisicaDTO;
import com.saludsystem.application.dto.put.historialclinico.ActualizarExploracionFisicaDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface ExploracionFisicaService extends GenericService<
        ExploracionFisicaDTO,
        CrearExploracionFisicaDTO,
        ActualizarExploracionFisicaDTO,
        UUID> {
}