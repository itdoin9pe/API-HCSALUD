package com.saludsystem.submodules.mantenimiento.mapper;

import com.saludsystem.submodules.mantenimiento.model.TipoGasto;
import com.saludsystem.submodules.mantenimiento.dtos.get.TipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.dtos.post.CrearTipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.dtos.put.ActualizarTipoGastoDTO;

import java.util.UUID;

public class TipoGastoMapper {

    public static TipoGasto fromCreateDto(CrearTipoGastoDTO dto) {
        return new TipoGasto(null, dto.getNombre(), dto.getEstado());
    }

    public static TipoGasto fromUpdateDto(UUID uuid, ActualizarTipoGastoDTO dto) {
        return new TipoGasto(uuid, dto.getNombre(), dto.getEstado());
    }

    public static TipoGastoDTO toDto(TipoGasto model) {
        return new TipoGastoDTO(
                model.getConceptoGastoId(),
                model.getNombre(),
                model.getEstado());
    }
}
