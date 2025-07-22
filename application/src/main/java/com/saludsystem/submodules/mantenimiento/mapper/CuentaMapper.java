package com.saludsystem.submodules.mantenimiento.mapper;

import com.saludsystem.submodules.mantenimiento.model.Cuenta;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.CuentaDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearCuentaDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarCuentaDTO;

import java.util.UUID;

public class CuentaMapper {

    public static Cuenta fromCreateDto(CrearCuentaDTO dto) {
        return new Cuenta(null, dto.getNombre(), dto.getTotal(), dto.getEstado());
    }

    public static Cuenta fromUpdateDto(UUID uuid, ActualizarCuentaDTO dto) {
        return new Cuenta(uuid, dto.getNombre(), dto.getTotal(), dto.getEstado());
    }

    public static CuentaDTO toDto(Cuenta model) {
        return new CuentaDTO(model.getId(), model.getNombre(), model.getTotal(), model.getEstado());
    }

}
