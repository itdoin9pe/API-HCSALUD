package com.saludsystem.submodules.mantenimiento.mapper;

import com.saludsystem.submodules.mantenimiento.model.Enfermedad;
import com.saludsystem.submodules.mantenimiento.dtos.get.EnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.dtos.post.CrearEnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.dtos.put.ActualizarEnfermedadDTO;

public class EnfermedadMapper {

    public static Enfermedad fromCreateDto(CrearEnfermedadDTO dto) {
        return new Enfermedad(null, dto.getDescripcion(), dto.getEstado());
    }

    public static Enfermedad fromUpdateDto(String id, ActualizarEnfermedadDTO dto) {
        return new Enfermedad(id, dto.getDescripcion(), dto.getEstado());
    }

    public static EnfermedadDTO toDto(Enfermedad model) {
        return new EnfermedadDTO(
                model.getId(),
                model.getDescripcion(),
                model.getEstado());
    }

}
