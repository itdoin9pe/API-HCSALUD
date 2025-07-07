package com.saludsystem.application.services.operaciones;

import com.saludsystem.application.dtos.operaciones.get.CategoriaMatDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearCategotiaMatDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface CategoriaMatService extends GenericService<
        CrearCategotiaMatDTO,
        CategoriaMatDTO,
        UUID> {
}