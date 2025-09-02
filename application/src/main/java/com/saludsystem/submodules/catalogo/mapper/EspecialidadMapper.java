package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.EspecialidadCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.EspecialidadEditCommand;
import com.saludsystem.submodules.catalogo.model.Especialidad;

import java.util.UUID;

public class EspecialidadMapper {

    public Especialidad fromCreateDto(EspecialidadCreateCommand dto) {
        return new Especialidad(null, dto.getNombre(), dto.getDescripcion(), dto.getEstado());
    }

    public Especialidad fromUpdateDto(UUID uuid, EspecialidadEditCommand dto) {
        return new Especialidad(uuid, dto.getNombre(), dto.getDescripcion(), dto.getEstado());
    }

    public EspecialidadDTO toDto(Especialidad model) {
        return new EspecialidadDTO(model.getId(), model.getNombre(), model.getDescripcion(), model.getEstado());
    }

}