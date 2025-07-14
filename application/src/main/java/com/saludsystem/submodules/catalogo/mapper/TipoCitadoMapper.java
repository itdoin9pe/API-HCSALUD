package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.dtos.get.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.dtos.post.CrearTipoCitadoDTO;
import com.saludsystem.submodules.catalogo.dtos.put.ActualizarTipoCitadoDTO;
import com.saludsystem.submodules.catalogo.model.TipoCitado;

import java.util.UUID;

public class TipoCitadoMapper {

    public static TipoCitado formCreatoDto(CrearTipoCitadoDTO dto) {
        return new TipoCitado(null, dto.getNombre(), dto.getColor(), dto.getEstado());
    }

    public static TipoCitado fromUpdateDto(UUID uuid, ActualizarTipoCitadoDTO dto) {
        return new TipoCitado(uuid, dto.getNombre(), dto.getColor(), dto.getEstado());
    }

    public static TipoCitadoDTO toDto(TipoCitado model) {
        return new TipoCitadoDTO(model.getId(), model.getNombre(), model.getColor(), model.getEstado());
    }
}
