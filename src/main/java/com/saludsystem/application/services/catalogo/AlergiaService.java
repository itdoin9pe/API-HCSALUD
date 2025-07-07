package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.services.GenericService;
import com.saludsystem.application.dtos.catalogo.req.AlergiaDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearAlergiaDTO;

import java.util.UUID;

public interface AlergiaService extends GenericService<
        CrearAlergiaDTO,
        AlergiaDTO,
        UUID> {
}