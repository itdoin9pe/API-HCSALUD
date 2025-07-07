package com.saludsystem.application.services.operaciones;

import com.saludsystem.application.dtos.operaciones.get.UnidadDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearUnidadDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface  UnidadService  extends GenericService<
        CrearUnidadDTO,
        UnidadDTO,
        UUID> {
}