package com.saludsystem.paciente.application.service.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.AntecedenteResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.AntecedenteRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface AntecedenteService extends GenericService<
        AntecedenteRequest,
        AntecedenteResponse,
        UUID> {
}