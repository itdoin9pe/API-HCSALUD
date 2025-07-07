package com.saludsystem.application.services.operaciones;

import com.saludsystem.application.dtos.operaciones.get.ProveedorDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearProveedorDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface ProveedorService extends GenericService<
        CrearProveedorDTO,
        ProveedorDTO,
        UUID> {
}