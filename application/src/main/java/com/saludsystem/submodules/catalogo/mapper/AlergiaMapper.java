package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.dto.command.CrearAlergiaDTO;
import com.saludsystem.submodules.catalogo.dto.edit.ActualizarAlergiaDTO;
import com.saludsystem.submodules.catalogo.model.Alergia;

import java.util.UUID;

public class AlergiaMapper {

    public static Alergia fromCreateDto(CrearAlergiaDTO dto) {
        return new Alergia(null, dto.getNombre(), dto.getEstado());
    }

    public static Alergia fromUpdateDto(UUID id, ActualizarAlergiaDTO dto) {
        return new Alergia(id, dto.getNombre(), dto.getEstado());
    }

    public static AlergiaDTO toDto(Alergia model) {
        return new AlergiaDTO(
                model.getId(),
                model.getNombre(),
                model.getEstado());
    }
}