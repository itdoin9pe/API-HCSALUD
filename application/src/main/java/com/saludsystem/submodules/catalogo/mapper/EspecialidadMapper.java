package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.CrearEspecialidadDTO;
import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarEspecialidadDTO;
import com.saludsystem.submodules.catalogo.model.Especialidad;

import java.util.UUID;

public class EspecialidadMapper {

    public static Especialidad fromCreateDto(CrearEspecialidadDTO dto) {
        return new Especialidad(null, dto.getNombre(), dto.getDescripcion(), dto.getEstado());
    }

    public static Especialidad fromUpdateDto(UUID uuid, ActualizarEspecialidadDTO dto) {
        return new Especialidad(uuid, dto.getNombre(), dto.getDescripcion(), dto.getEstado());
    }

    public static EspecialidadDTO toDto(Especialidad model) {
        return new EspecialidadDTO(model.getId(), model.getDescripcion(), model.getNombre(), model.getEstado());
    }

}