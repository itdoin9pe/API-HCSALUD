package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.AlergiaCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarAlergiaDTO;
import com.saludsystem.submodules.catalogo.model.Alergia;

import java.util.UUID;

public class AlergiaMapper {

    public static Alergia fromCreateDto(AlergiaCreateCommand dto) {
        return new Alergia(null, dto.getNombre(), dto.getEstado());
    }

    public static Alergia fromUpdateDto(UUID id, ActualizarAlergiaDTO dto) {
        return new Alergia(id, dto.getNombre(), dto.getEstado());
    }

    public static AlergiaCreateCommand toDto(Alergia model) {
        return new AlergiaCreateCommand(
                model.getId(),
                model.getNombre(),
                model.getEstado());
    }
}