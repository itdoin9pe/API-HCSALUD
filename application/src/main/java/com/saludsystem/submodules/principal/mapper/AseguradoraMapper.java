package com.saludsystem.submodules.principal.mapper;

import com.saludsystem.submodules.principal.model.dtos.get.AseguradoraDTO;
import com.saludsystem.submodules.principal.model.dtos.post.CrearAseguradoraDTO;
import com.saludsystem.submodules.principal.model.dtos.put.ActualizarAseguradoraDTO;
import com.saludsystem.submodules.principal.model.Aseguradora;

import java.util.UUID;

public class AseguradoraMapper {

    public static Aseguradora fromCreateDto(CrearAseguradoraDTO dto) {
        return new Aseguradora(null, dto.getDescripcion(),dto.getEstado());
    }

    public static Aseguradora fromUpdateDto(UUID uuid, ActualizarAseguradoraDTO dto) {
        return new Aseguradora(uuid, dto.getDescripcion(), dto.getEstado());
    }

    public static AseguradoraDTO toDto(Aseguradora model) {
        return new AseguradoraDTO(
                model.getAseguradoraId(),
                model.getDescripcion(),
                model.getEstado());
    }
}
