package com.saludsystem.application.catalogo.mapper;

import com.saludsystem.application.catalogo.dtos.get.ApoderadoDTO;
import com.saludsystem.application.catalogo.dtos.post.CrearApoderadoDTO;
import com.saludsystem.application.catalogo.dtos.put.ActualizarApoderadoDTO;
import com.saludsystem.domain.catalogo.model.Apoderado;

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