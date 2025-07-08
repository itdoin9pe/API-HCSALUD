package com.saludsystem.paciente.application.service.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.ExploracionFisicaResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.ExploracionFisicaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ExploracionFisicaService extends GenericService<
        ExploracionFisicaRequest,
        ExploracionFisicaResponse,
        UUID> {
}