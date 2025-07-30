package com.saludsystem.submodules.mantenimiento.mapper;

import com.saludsystem.submodules.mantenimiento.model.Banco;
import com.saludsystem.submodules.mantenimiento.dtos.get.BancoDTO;
import com.saludsystem.submodules.mantenimiento.dtos.post.CrearBancoDTO;
import com.saludsystem.submodules.mantenimiento.dtos.put.ActualizarBancoDTO;

import java.util.UUID;

public class BancoMapper {

    public static Banco fromCreateDto(CrearBancoDTO dto) {
        return new Banco(null, dto.getDescripcion(), dto.getEstado());
    }

    public static Banco fromUpdateDto(UUID uuid, ActualizarBancoDTO dto) {
        return new Banco(uuid, dto.getDescripcion(), dto.getEstado());
    }

    public static BancoDTO toDto(Banco model) {
        return new BancoDTO(model.getId(), model.getDescripcion(), model.getEstado());
    }

}
