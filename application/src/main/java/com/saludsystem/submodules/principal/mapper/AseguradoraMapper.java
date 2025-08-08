package com.saludsystem.submodules.principal.mapper;

import com.saludsystem.submodules.principal.model.dtos.AseguradoraDTO;
import com.saludsystem.submodules.principal.model.dtos.command.AseguradoraCreateCommand;
import com.saludsystem.submodules.principal.model.dtos.command.edit.AseguradoraEditCommand;
import com.saludsystem.submodules.principal.model.Aseguradora;

import java.util.UUID;

public class AseguradoraMapper {

    public Aseguradora fromCreateDto(AseguradoraCreateCommand dto) {
        return new Aseguradora(null, dto.getDescripcion(),dto.getEstado());
    }

    public Aseguradora fromUpdateDto(UUID uuid, AseguradoraEditCommand dto) {
        return new Aseguradora(uuid, dto.getDescripcion(), dto.getEstado());
    }

    public AseguradoraDTO toDto(Aseguradora model) {
        return new AseguradoraDTO(
                model.getAseguradoraId(),
                model.getDescripcion(),
                model.getEstado());
    }
}
