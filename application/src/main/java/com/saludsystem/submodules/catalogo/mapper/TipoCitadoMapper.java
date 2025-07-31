package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.TipoCitadoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.TipoCitadoEditCommand;
import com.saludsystem.submodules.catalogo.model.TipoCitado;

import java.util.UUID;

public class TipoCitadoMapper {

    public TipoCitado formCreatoDto(TipoCitadoCreateCommand dto) {
        return new TipoCitado(null, dto.getNombre(), dto.getColor(), dto.getEstado());
    }

    public TipoCitado fromUpdateDto(UUID uuid, TipoCitadoEditCommand dto) {
        return new TipoCitado(uuid, dto.getNombre(), dto.getColor(), dto.getEstado());
    }

    public TipoCitadoDTO toDto(TipoCitado model) {
        return new TipoCitadoDTO(model.getId(), model.getNombre(), model.getColor(), model.getEstado());
    }
}
