package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.dtos.get.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.dtos.post.CrearEspecialidadDTO;
import com.saludsystem.submodules.catalogo.dtos.put.ActualizarEspecialidadDTO;
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