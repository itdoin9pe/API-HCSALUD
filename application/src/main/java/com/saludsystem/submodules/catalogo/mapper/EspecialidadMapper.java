package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.EspecialidadCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarEspecialidadDTO;
import com.saludsystem.submodules.catalogo.model.Especialidad;

import java.util.UUID;

public class EspecialidadMapper {

    public static Especialidad fromCreateDto(EspecialidadCreateCommand dto) {
        return new Especialidad(null, dto.getNombre(), dto.getDescripcion(), dto.getEstado());
    }

    public static Especialidad fromUpdateDto(UUID uuid, ActualizarEspecialidadDTO dto) {
        return new Especialidad(uuid, dto.getNombre(), dto.getDescripcion(), dto.getEstado());
    }

    public static EspecialidadCreateCommand toDto(Especialidad model) {
        return new EspecialidadCreateCommand(model.getId(), model.getDescripcion(), model.getNombre(), model.getEstado());
    }

}