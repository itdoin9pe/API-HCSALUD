package com.saludsystem.submodules.mantenimiento.mapper;

import com.saludsystem.submodules.mantenimiento.model.Moneda;
import com.saludsystem.submodules.mantenimiento.dtos.get.MonedaDTO;
import com.saludsystem.submodules.mantenimiento.dtos.post.CrearMonedaDTO;
import com.saludsystem.submodules.mantenimiento.dtos.put.ActualizarMonedaDTO;

import java.util.UUID;

public class MonedaMapper {

    public static Moneda fromCreateDto(CrearMonedaDTO dto) {
        return new Moneda(null, dto.getDescripcion(), dto.getEstado());
    }

    public static Moneda fromUpdateDto(UUID uuid, ActualizarMonedaDTO dto) {
        return new Moneda(uuid, dto.getDescripcion(), dto.getEstado());
    }

    public static MonedaDTO toDto(Moneda model) {
        return new MonedaDTO(
                model.getId(),
                model.getDescripcion(),
                model.getEstado());
    }
}
