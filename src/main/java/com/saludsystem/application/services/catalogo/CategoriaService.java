package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.put.ActualizarCategoriaDTO;
import com.saludsystem.application.dtos.catalogo.get.CategoriaDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearCategoriaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface CategoriaService extends GenericService<CategoriaDTO, UUID,
        CrearCategoriaDTO, ActualizarCategoriaDTO> {
}