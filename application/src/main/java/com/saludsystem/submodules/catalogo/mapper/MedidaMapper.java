package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.MedidaCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.MedidaEditCommand;
import com.saludsystem.submodules.catalogo.model.Medida;

import java.util.UUID;

public class MedidaMapper {

    public Medida fromCreatDto(MedidaCreateCommand dto) {
        return new Medida(null, dto.getNombre(), dto.getEstado());
    }

    public Medida fromUpdateDto(UUID uuid, MedidaEditCommand dto){
        return new Medida(uuid, dto.getNombre(), dto.getEstado());
    }

    public MedidaDTO toDto(Medida model) {
        return new MedidaDTO(model.getId(), model.getNombre(), model.getEstado());
    }

}