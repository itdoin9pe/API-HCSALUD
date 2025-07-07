package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.UnidadDTO;
import com.saludsystem.operaciones.application.dto.req.CrearUnidadDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface  UnidadService  extends GenericService<
        CrearUnidadDTO,
        UnidadDTO,
        UUID> {
}