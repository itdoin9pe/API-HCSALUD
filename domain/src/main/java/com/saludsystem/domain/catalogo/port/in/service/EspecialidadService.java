package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.catalogo.application.dtos.get.EspecialidadDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearEspecialidadDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarEspecialidadDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface EspecialidadService extends GenericService<
        EspecialidadDTO,
        CrearEspecialidadDTO,
        ActualizarEspecialidadDTO,
        UUID> {
}