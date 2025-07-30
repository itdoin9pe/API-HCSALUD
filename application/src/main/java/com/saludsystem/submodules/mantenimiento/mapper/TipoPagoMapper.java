package com.saludsystem.submodules.mantenimiento.mapper;

import com.saludsystem.submodules.mantenimiento.model.TipoPago;
import com.saludsystem.submodules.mantenimiento.dtos.get.TipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.dtos.post.CrearTipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.dtos.put.ActualizarTipoPagoDTO;

import java.util.UUID;

public class TipoPagoMapper {

    public static TipoPago fromCreateDto(CrearTipoPagoDTO dto) {
        return new TipoPago(null, dto.getMetodoPago(), dto.getDescripcion(), dto.getEstado());
    }

    public static TipoPago fromUpdateDto(UUID uuid, ActualizarTipoPagoDTO dto) {
        return new TipoPago(uuid, dto.getMetodoPago(), dto.getDescripcion(), dto.getEstado());
    }

    public static TipoPagoDTO toDto(TipoPago model) {
        return new TipoPagoDTO(
                model.getTipoPagoId(),
                model.getDescripcion(),
                model.getMetodoPago(),
                model.getEstado());
    }
}
