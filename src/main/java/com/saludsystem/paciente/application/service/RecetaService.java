package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.get.RecetaDTO;
import com.saludsystem.paciente.application.dto.post.CrearRecetaDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarRecetaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface RecetaService extends GenericService<
        RecetaDTO,
        CrearRecetaDTO,
        ActualizarRecetaDTO,
        UUID> {
}