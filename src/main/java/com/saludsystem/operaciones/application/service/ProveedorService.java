package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.ProveedorDTO;
import com.saludsystem.operaciones.application.dto.req.CrearProveedorDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ProveedorService extends GenericService<
        CrearProveedorDTO,
        ProveedorDTO,
        UUID> {
}