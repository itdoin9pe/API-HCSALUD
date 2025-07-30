package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.CategoriaCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarCategoriaDTO;
import com.saludsystem.submodules.catalogo.model.Categoria;

import java.util.UUID;

public class CategoriaMapper {

    public static Categoria fromCreateDto(CategoriaCreateCommand dto) {
        return new Categoria(null, dto.getNombre(), dto.getEstado());
    }

    public static Categoria fromUpdateDto(UUID uuid, ActualizarCategoriaDTO dto) {
        return new Categoria(uuid, dto.getNombre(), dto.getEstado());
    }

    public static CategoriaCreateCommand toDto(Categoria model) {
        return new CategoriaCreateCommand(model.getId(), model.getNombre(), model.getEstado());
    }
}