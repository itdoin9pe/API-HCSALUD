package com.saludsystem.application.services.operaciones;

import com.saludsystem.application.dtos.operaciones.get.MarcaDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearMarcaDTO;
import com.saludsystem.application.dtos.operaciones.put.ActualizarMarcaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface MarcaService extends GenericService<
        MarcaDTO,
        UUID,
        CrearMarcaDTO,
        ActualizarMarcaDTO> {
}