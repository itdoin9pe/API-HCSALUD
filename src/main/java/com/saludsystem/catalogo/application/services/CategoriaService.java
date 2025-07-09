package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.get.CategoriaDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearCategoriaDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarCategoriaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CategoriaService extends GenericService<
        CategoriaDTO,
        CrearCategoriaDTO,
        ActualizarCategoriaDTO,
        UUID> {
}