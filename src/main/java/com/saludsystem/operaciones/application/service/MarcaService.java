package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.get.MarcaDTO;
import com.saludsystem.operaciones.application.dto.post.CrearMarcaDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarMarcaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MarcaService extends GenericService<
        MarcaDTO,
        CrearMarcaDTO,
        ActualizarMarcaDTO,
        UUID> {
}