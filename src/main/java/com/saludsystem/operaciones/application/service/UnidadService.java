package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.get.UnidadDTO;
import com.saludsystem.operaciones.application.dto.post.CrearUnidadDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarUnidadDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface  UnidadService  extends GenericService<
        UnidadDTO,
        CrearUnidadDTO,
        ActualizarUnidadDTO,
        UUID> {
}