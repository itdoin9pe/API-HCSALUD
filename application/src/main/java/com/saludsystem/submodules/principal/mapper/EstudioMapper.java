package com.saludsystem.submodules.principal.mapper;

import com.saludsystem.submodules.principal.model.Estudio;
import com.saludsystem.submodules.principal.model.dtos.EstudioDTO;
import com.saludsystem.submodules.principal.model.dtos.command.EstudioCreateCommand;
import com.saludsystem.submodules.principal.model.dtos.command.edit.EstudioEditCommand;

import java.util.UUID;

public class EstudioMapper {

    public Estudio fromCreateDto(EstudioCreateCommand dto) {
        return new Estudio(null, dto.getDescripcion());
    }

    public Estudio fromUpdateDto(UUID uuid, EstudioEditCommand dto) {
        return new Estudio(uuid, dto.getDescripcion());
    }

    public EstudioDTO toDto(Estudio model) {
        return new EstudioDTO(
                model.getId(),
                model.getDescripcion());
    }

}
