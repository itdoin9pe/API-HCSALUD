package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.MarcaDTO;
import com.saludsystem.operaciones.application.dto.req.CrearMarcaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MarcaService extends GenericService<
        CrearMarcaDTO,
        MarcaDTO,
        UUID> {
}