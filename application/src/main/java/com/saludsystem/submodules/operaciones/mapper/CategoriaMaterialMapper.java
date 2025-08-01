package com.saludsystem.submodules.operaciones.mapper;

import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;
import com.saludsystem.submodules.operaciones.dtos.query.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.dtos.command.CrearCategotiaMatDTO;
import com.saludsystem.submodules.operaciones.dtos.edit.ActualizarCategoriaMatDTO;

import java.util.UUID;

public class CategoriaMaterialMapper {

    public static CategoriaMaterial fromCreateDto(CrearCategotiaMatDTO dto) {
        return new CategoriaMaterial(null, dto.getNombre(), dto.getDescripcion(),
                dto.getEstado());
    }

    public static CategoriaMaterial fromUpdateDto(UUID uuid, ActualizarCategoriaMatDTO dto) {
        return new CategoriaMaterial(uuid, dto.getNombre(), dto.getDescripcion(), dto.getEstado());
    }

    public static CategoriaMatDTO toDto(CategoriaMaterial model) {
        return new CategoriaMatDTO(
                model.getCategoriaMaterialId(),
                model.getNombre(),
                model.getDescripcion(),
                model.getEstado());
    }

}
