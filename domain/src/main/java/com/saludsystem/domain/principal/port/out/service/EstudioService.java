package com.saludsystem.domain.principal.port.out.service;

import com.saludsystem.application.dto.get.EstudioDTO;
import com.saludsystem.application.dto.post.CrearEstudioDTO;
import com.saludsystem.application.dto.put.ActualizarEstudioDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface EstudioService extends GenericService<
        EstudioDTO,
        CrearEstudioDTO,
        ActualizarEstudioDTO,
        UUID> {
}