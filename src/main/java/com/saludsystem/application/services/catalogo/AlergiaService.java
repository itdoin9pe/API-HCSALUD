package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.services.GenericService;
import com.saludsystem.application.dtos.catalogo.put.ActualizarAlergiaDTO;
import com.saludsystem.application.dtos.catalogo.get.AlergiaDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearAlergiaDTO;

import java.util.UUID;

public interface AlergiaService extends GenericService<
        AlergiaDTO,
        UUID,
        CrearAlergiaDTO,
        ActualizarAlergiaDTO> {
}