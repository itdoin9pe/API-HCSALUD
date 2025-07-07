package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.CategoriaMatDTO;
import com.saludsystem.operaciones.application.dto.req.CrearCategotiaMatDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CategoriaMatService extends GenericService<
        CrearCategotiaMatDTO,
        CategoriaMatDTO,
        UUID> {
}