package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.dtos.get.CategoriaDTO;
import com.saludsystem.submodules.catalogo.dtos.post.CrearCategoriaDTO;
import com.saludsystem.submodules.catalogo.dtos.put.ActualizarCategoriaDTO;
import com.saludsystem.submodules.catalogo.model.Categoria;

import java.util.UUID;

public class CategoriaMapper {

    public static Categoria fromCreateDto(CrearCategoriaDTO dto) {
        return new Categoria(null, dto.getNombre(), dto.getEstado());
    }

    public static Categoria fromUpdateDto(UUID uuid, ActualizarCategoriaDTO dto) {
        return new Categoria(uuid, dto.getNombre(), dto.getEstado());
    }

    public static CategoriaDTO toDto(Categoria model) {
        return new CategoriaDTO(model.getId(), model.getNombre(), model.getEstado());
    }
}