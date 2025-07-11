package com.saludsystem.domain.paciente.port.in.service;

import com.saludsystem.application.dto.get.RecetaDTO;
import com.saludsystem.application.dto.post.CrearRecetaDTO;
import com.saludsystem.application.dto.put.ActualizarRecetaDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface RecetaService extends GenericService<
        RecetaDTO,
        CrearRecetaDTO,
        ActualizarRecetaDTO,
        UUID> {
}