package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.get.EstudioDTO;
import com.saludsystem.principal.application.dto.post.CrearEstudioDTO;
import com.saludsystem.principal.application.dto.put.ActualizarEstudioDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface EstudioService extends GenericService<
        EstudioDTO,
        CrearEstudioDTO,
        ActualizarEstudioDTO,
        UUID> {
}