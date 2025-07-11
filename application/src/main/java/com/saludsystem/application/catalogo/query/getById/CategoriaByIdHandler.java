package com.saludsystem.application.catalogo.query.getById;

import com.saludsystem.application.catalogo.dtos.get.CategoriaDTO;
import com.saludsystem.application.catalogo.dtos.post.CrearCategoriaDTO;
import com.saludsystem.application.catalogo.dtos.put.ActualizarCategoriaDTO;
import com.saludsystem.domain.catalogo.model.Categoria;

import java.util.UUID;

public class CategoriaByIdHandler {

    public static Categoria fromCreateDto(CrearCategoriaDTO dto) {
        return new Categoria(null, dto.getNombre(), dto.getEstado());
    }

    public static Categoria fromUpdateDto(UUID id, ActualizarCategoriaDTO dto) {
        return new Categoria(id, dto.getNombre(), dto.getEstado());
    }

    public static CategoriaDTO toDto(Categoria model) {
        return new CategoriaDTO(model.getId(), model.getNombre(), model.getEstado());
    }
}