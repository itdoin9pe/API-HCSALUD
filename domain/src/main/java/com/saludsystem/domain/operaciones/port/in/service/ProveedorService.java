package com.saludsystem.domain.operaciones.port.in.service;

import com.saludsystem.operaciones.application.dto.get.ProveedorDTO;
import com.saludsystem.operaciones.application.dto.post.CrearProveedorDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarProveedorDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ProveedorService extends GenericService<
        ProveedorDTO,
        CrearProveedorDTO,
        ActualizarProveedorDTO,
        UUID> {
}