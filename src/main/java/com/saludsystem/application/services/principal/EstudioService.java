package com.saludsystem.application.services.principal;

import com.saludsystem.application.dtos.principal.get.EstudioDTO;
import com.saludsystem.application.dtos.principal.post.CrearEstudioDTO;
import com.saludsystem.application.dtos.principal.put.ActualizarEstudioDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface EstudioService extends GenericService<
        EstudioDTO,
        UUID,
        CrearEstudioDTO,
        ActualizarEstudioDTO> {
}