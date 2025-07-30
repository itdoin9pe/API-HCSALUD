package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.dto.ApoderadoDTO;
import com.saludsystem.submodules.catalogo.dto.command.CrearApoderadoDTO;
import com.saludsystem.submodules.catalogo.dto.edit.ActualizarApoderadoDTO;
import com.saludsystem.submodules.catalogo.model.Apoderado;

import java.util.UUID;

public class ApoderadoMapper {

    public static Apoderado fromCreateDto(CrearApoderadoDTO dto) {
        return new Apoderado(null, dto.getNombre(), dto.getTelefono(),
                dto.getNroDocumento(), dto.getDireccion(), dto.getEstado());
    }

    public static Apoderado fromUpdateDto(UUID id, ActualizarApoderadoDTO dto) {
        return new Apoderado(id, dto.getNombre(), dto.getTelefono(),
                dto.getNroDocumento(), dto.getDireccion(), dto.getEstado());
    }

    public static ApoderadoDTO toDto(Apoderado model) {
        return new ApoderadoDTO(model.getId(), model.getNombre(), model.getNroDocumento(),
                model.getDireccion(), model.getTelefono(), model.getEstado());

    }
}