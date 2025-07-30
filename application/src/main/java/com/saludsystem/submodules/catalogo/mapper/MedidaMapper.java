package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.MedidaCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarMedidaDTO;
import com.saludsystem.submodules.catalogo.model.Medida;

import java.util.UUID;

public class MedidaMapper {

    public static Medida fromCreatDto(MedidaCreateCommand dto) {
        return new Medida(null, dto.getNombre(), dto.getEstado());
    }

    public static Medida fromUpdateDto(UUID uuid, ActualizarMedidaDTO dto){
        return new Medida(uuid, dto.getNombre(), dto.getEstado());
    }

    public static MedidaCreateCommand toDto(Medida model) {
        return new MedidaCreateCommand(model.getId(), model.getNombre(), model.getEstado());
    }

}