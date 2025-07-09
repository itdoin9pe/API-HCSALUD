package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.put.ActualizarAlergiaDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.catalogo.application.dtos.post.CrearAlergiaDTO;
import com.saludsystem.catalogo.application.dtos.get.AlergiaDTO;

import java.util.UUID;

public interface AlergiaService extends GenericService<
        AlergiaDTO,
        CrearAlergiaDTO,
        ActualizarAlergiaDTO,
        UUID> {
}