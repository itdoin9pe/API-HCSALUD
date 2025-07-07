package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.res.RecetaDTO;
import com.saludsystem.paciente.application.dto.req.CrearRecetaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface RecetaService extends GenericService<
        CrearRecetaDTO,
        RecetaDTO,
        UUID> {
}