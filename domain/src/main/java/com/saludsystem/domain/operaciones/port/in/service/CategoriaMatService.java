package com.saludsystem.domain.operaciones.port.in.service;

import com.saludsystem.operaciones.application.dto.get.CategoriaMatDTO;
import com.saludsystem.operaciones.application.dto.post.CrearCategotiaMatDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarCategoriaMatDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CategoriaMatService extends GenericService<
        CategoriaMatDTO,
        CrearCategotiaMatDTO,
        ActualizarCategoriaMatDTO,
        UUID> {
}