package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.AlergiaCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.AlergiaEditCommand;
import com.saludsystem.submodules.catalogo.model.Alergia;

import java.util.UUID;

public class AlergiaMapper {

    public Alergia fromCreateDto(AlergiaCreateCommand dto) {
        return new Alergia(null, dto.getNombre(), dto.getEstado());
    }

    public Alergia fromUpdateDto(UUID id, AlergiaEditCommand dto) {
        return new Alergia(id, dto.getNombre(), dto.getEstado());
    }

    public AlergiaDTO toDto(Alergia model) {
        return new AlergiaDTO(
                model.getId(),
                model.getNombre(),
                model.getEstado());
    }

}