package com.saludsystem.submodules.principal.mapper;

import com.saludsystem.submodules.principal.model.Estudio;
import com.saludsystem.submodules.principal.dtos.get.EstudioDTO;
import com.saludsystem.submodules.principal.dtos.post.CrearEstudioDTO;
import com.saludsystem.submodules.principal.dtos.put.ActualizarEstudioDTO;

import java.util.UUID;

public class EstudioMapper {

    public static Estudio fromCreateDto(CrearEstudioDTO dto) {
        return new Estudio(null, dto.getDescripcion());
    }

    public static Estudio fromUpdateDto(UUID uuid, ActualizarEstudioDTO dto) {
        return new Estudio(uuid, dto.getDescripcion());
    }

    public static EstudioDTO toDto(Estudio model) {
        return new EstudioDTO(
                model.getId(),
                model.getDescripcion());
    }

}
