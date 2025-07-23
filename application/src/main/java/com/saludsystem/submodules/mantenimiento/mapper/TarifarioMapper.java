package com.saludsystem.submodules.mantenimiento.mapper;

import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.TarifarioDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearTarifarioDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarTarifarioDTO;

import java.util.UUID;

public class TarifarioMapper {

    public static Tarifario fromCreateDto(CrearTarifarioDTO dto) {
        return new Tarifario(null,
                dto.getTipoConceptoId(), dto.getCategoriaId(), dto.getMedidaId(),
                dto.getUnidadId(), dto.getGrupo(), dto.getDescripcion(),
                dto.getPrecio(), dto.getEstado());
    }

    public static Tarifario fromUpdateDto(UUID uuid, ActualizarTarifarioDTO dto) {
        return new Tarifario(uuid,
                dto.getTipoConceptoId(), dto.getCategoriaId(), dto.getMedidaId(),
                dto.getUnidadId(), dto.getGrupo(), dto.getDescripcion(),
                dto.getPrecio(), dto.getEstado());
    }

    public static TarifarioDTO toDto(Tarifario model) {
        return new TarifarioDTO(
                model.getId(),
                model.getTipoConceptoId(),
                model.getCategoriaId(),
                model.getMedidaId(),
                model.getUnidadId(),
                model.getGrupo(),
                model.getDescripcion(),
                model.getPrecio(),
                model.getEstado());
    }

}
