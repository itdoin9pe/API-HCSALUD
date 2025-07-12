package com.saludsystem.application.catalogo.mapper;

import com.saludsystem.application.catalogo.dtos.get.EspecialidadDTO;
import com.saludsystem.application.catalogo.dtos.post.CrearEspecialidadDTO;
import com.saludsystem.application.catalogo.dtos.put.ActualizarEspecialidadDTO;
import com.saludsystem.domain.catalogo.model.Especialidad;

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