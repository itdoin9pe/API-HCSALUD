package com.saludsystem.submodules.principal.mapper;

import com.saludsystem.submodules.principal.model.Pais;
import com.saludsystem.submodules.principal.dtos.get.PaisDTO;
import com.saludsystem.submodules.principal.dtos.post.CrearPaisDTO;
import com.saludsystem.submodules.principal.dtos.put.ActualizarPaisDTO;

public class PaisMapper {

    public static Pais fromCreateDto(CrearPaisDTO dto) {
        return new Pais(null, dto.getIso(), dto.getNombre(), dto.getGentilicio(), dto.getOrden());
    }

    public static Pais fromUpdateDto(Integer uuid, ActualizarPaisDTO dto) {
        return new Pais(uuid, dto.getIso(), dto.getNombre(), dto.getGentilicio(), dto.getOrden());
    }

    public static PaisDTO toDto(Pais model) {
        return new PaisDTO(
                model.getId(),
                model.getGentilicio(),
                model.getNombre(),
                model.getIso(),
                model.getOrden());
    }

}
