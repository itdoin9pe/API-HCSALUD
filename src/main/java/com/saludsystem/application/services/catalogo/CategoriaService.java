package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.req.CategoriaDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearCategoriaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface CategoriaService extends GenericService<
        CrearCategoriaDTO,
        CategoriaDTO,
        UUID> {
}