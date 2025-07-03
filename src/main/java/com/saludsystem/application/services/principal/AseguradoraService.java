package com.saludsystem.application.services.principal;

import com.saludsystem.application.dtos.principal.get.AseguradoraDTO;
import com.saludsystem.application.dtos.principal.post.CrearAseguradoraDTO;
import com.saludsystem.application.dtos.principal.put.ActualizarAseguradoraDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface AseguradoraService extends GenericService<
        AseguradoraDTO,
        UUID,
        CrearAseguradoraDTO,
        ActualizarAseguradoraDTO> {
}