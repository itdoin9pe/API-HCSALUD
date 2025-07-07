package com.saludsystem.catalogo.application.services;

import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.catalogo.application.dtos.res.AlergiaDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearAlergiaDTO;

import java.util.UUID;

public interface AlergiaService extends GenericService<
        CrearAlergiaDTO,
        AlergiaDTO,
        UUID> {
}