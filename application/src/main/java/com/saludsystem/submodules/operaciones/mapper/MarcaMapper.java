package com.saludsystem.submodules.operaciones.mapper;

import com.saludsystem.submodules.operaciones.dtos.command.CrearMarcaDTO;
import com.saludsystem.submodules.operaciones.dtos.edit.ActualizarMarcaDTO;
import com.saludsystem.submodules.operaciones.dtos.query.MarcaDTO;
import com.saludsystem.submodules.operaciones.model.Marca;

import java.util.UUID;

public class MarcaMapper {

    public static Marca fronCreateDto(CrearMarcaDTO dto) {
        return new Marca(null, dto.getNombre(), dto.getEstado());
    }

    public static Marca fromUpdateDto(UUID uuid, ActualizarMarcaDTO dto) {
        return new Marca(uuid, dto.getNombre(), dto.getEstado());
    }

    public static MarcaDTO toDto(Marca model) {
        return new MarcaDTO(
                model.getId(),
                model.getNombre(),
                model.getEstado());
    }

}
