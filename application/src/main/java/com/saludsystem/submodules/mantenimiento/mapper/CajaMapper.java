package com.saludsystem.submodules.mantenimiento.mapper;

import com.saludsystem.submodules.mantenimiento.model.Caja;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.CajaDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearCajaDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarCajaDTO;

import java.util.UUID;

public class CajaMapper {

    public static Caja fromCreateDto(CrearCajaDTO dto) {
        return new Caja(null, dto.getNombre(), dto.getEstado());
    }

    public static Caja fromUpdateDto(UUID uuid, ActualizarCajaDTO dto) {
        return new Caja(uuid, dto.getNombre(), dto.getEstado());
    }

    public static CajaDTO toDto(Caja model) {
        return new CajaDTO(model.getId(), model.getNombre(), model.getEstado());
    }
}
