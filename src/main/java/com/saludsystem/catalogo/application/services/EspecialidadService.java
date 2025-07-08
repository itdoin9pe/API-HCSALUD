package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.EspecialidadRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface EspecialidadService extends GenericService<
        com.saludsystem.catalogo.application.dtos.req.EspecialidadRequest,
        EspecialidadRequest,
        UUID> {
}