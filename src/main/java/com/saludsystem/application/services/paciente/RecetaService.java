package com.saludsystem.application.services.paciente;

import com.saludsystem.application.dtos.paciente.get.RecetaDTO;
import com.saludsystem.application.dtos.paciente.post.CrearRecetaDTO;
import com.saludsystem.application.dtos.paciente.put.ActualizarRecetaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface RecetaService extends GenericService<
        RecetaDTO,
        UUID,
        CrearRecetaDTO,
        ActualizarRecetaDTO> {
}