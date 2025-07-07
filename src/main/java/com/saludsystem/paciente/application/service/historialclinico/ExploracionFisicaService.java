package com.saludsystem.paciente.application.service.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.CrearExploracionFisicaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ExploracionFisicaService extends GenericService<
        CrearExploracionFisicaDTO,
        ExploracionFisicaDTO,
        UUID> {
}