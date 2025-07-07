package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.CategoriaDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearCategoriaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CategoriaService extends GenericService<
        CrearCategoriaDTO,
        CategoriaDTO,
        UUID> {
}