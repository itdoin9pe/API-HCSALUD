package com.saludsystem.submodules.mantenimiento.mapper;

import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;
import com.saludsystem.submodules.mantenimiento.dtos.get.TipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.dtos.post.CrearTipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.dtos.put.ActualizarTipoTarjetaDTO;

import java.util.UUID;

public class TipoTarjetaMapper {

    public static TipoTarjeta fromCreateDto(CrearTipoTarjetaDTO dto) {
        return new TipoTarjeta(null, dto.getDescripcion(), dto.getEstado());
    }

    public static TipoTarjeta fromUpdateDto(UUID uuid, ActualizarTipoTarjetaDTO dto) {
        return new TipoTarjeta(uuid, dto.getDescripcion(), dto.getEstado());
    }

    public static TipoTarjetaDTO toDto(TipoTarjeta model) {
        return new TipoTarjetaDTO(
                model.getTipoTarjetaId(),
                model.getDescripcion(),
                model.getEstado()
        );
    }
}
