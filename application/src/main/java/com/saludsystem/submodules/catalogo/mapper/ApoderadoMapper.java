package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.ApoderadoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarApoderadoDTO;
import com.saludsystem.submodules.catalogo.model.Apoderado;

import java.util.UUID;

public class ApoderadoMapper {

    public static Apoderado fromCreateDto(ApoderadoCreateCommand dto) {
        return new Apoderado(null, dto.getNombre(), dto.getTelefono(),
                dto.getNroDocumento(), dto.getDireccion(), dto.getEstado());
    }

    public static Apoderado fromUpdateDto(UUID id, ActualizarApoderadoDTO dto) {
        return new Apoderado(id, dto.getNombre(), dto.getTelefono(),
                dto.getNroDocumento(), dto.getDireccion(), dto.getEstado());
    }

    public static ApoderadoCreateCommand toDto(Apoderado model) {
        return new ApoderadoCreateCommand(model.getId(), model.getNombre(), model.getNroDocumento(),
                model.getDireccion(), model.getTelefono(), model.getEstado());

    }
}