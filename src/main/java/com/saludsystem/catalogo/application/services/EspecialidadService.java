package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.EspecialidadDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearEspecialidadDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface EspecialidadService extends GenericService<
        CrearEspecialidadDTO,
        EspecialidadDTO,
        UUID> {
}