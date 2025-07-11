package com.saludsystem.domain.principal.port.out.service;

import com.saludsystem.application.dto.get.AseguradoraDTO;
import com.saludsystem.application.dto.post.CrearAseguradoraDTO;
import com.saludsystem.application.dto.put.ActualizarAseguradoraDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface AseguradoraService extends GenericService<
        AseguradoraDTO,
        CrearAseguradoraDTO,
        ActualizarAseguradoraDTO,
        UUID> {
}