package com.saludsystem.application.catalogo.mapper;

import com.saludsystem.application.catalogo.dtos.get.AlergiaDTO;
import com.saludsystem.application.catalogo.dtos.post.CrearAlergiaDTO;
import com.saludsystem.application.catalogo.dtos.put.ActualizarAlergiaDTO;
import com.saludsystem.domain.catalogo.model.Alergia;

import java.util.UUID;

public class AlergiaMapper {

    public static Alergia fromCreateDto(CrearAlergiaDTO dto) {
        return new Alergia(null, dto.getNombre(), dto.getEstado());
    }

    public static Alergia fromUpdateDto(UUID id, ActualizarAlergiaDTO dto) {
        return new Alergia(id, dto.getNombre(), dto.getEstado());
    }

    public static AlergiaDTO toDto(Alergia model) {
        return new AlergiaDTO(model.getId(), model.getNombre(), model.getEstado());
    }
}