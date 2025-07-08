package com.saludsystem.paciente.application.service.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.ConsultaResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.ConsultaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ConsultaService extends GenericService<
        ConsultaRequest,
        ConsultaResponse,
        UUID> {
}