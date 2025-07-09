package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.get.AseguradoraDTO;
import com.saludsystem.principal.application.dto.post.CrearAseguradoraDTO;
import com.saludsystem.principal.application.dto.put.ActualizarAseguradoraDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface AseguradoraService extends GenericService<
        AseguradoraDTO,
        CrearAseguradoraDTO,
        ActualizarAseguradoraDTO,
        UUID> {
}