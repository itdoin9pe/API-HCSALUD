package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.req.EspecialidadDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearEspecialidadDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface EspecialidadService extends GenericService<
        CrearEspecialidadDTO,
        EspecialidadDTO,
        UUID> {
}