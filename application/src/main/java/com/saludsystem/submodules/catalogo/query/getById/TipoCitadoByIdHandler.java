package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dtos.get.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.catalogo.port.in.service.TipoCitadoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoCitadoByIdHandler {
    private final TipoCitadoService tipoCitadoService;

    public TipoCitadoByIdHandler(TipoCitadoService tipoCitadoService) {
        this.tipoCitadoService = tipoCitadoService;
    }

    public TipoCitadoDTO execute(UUID uuid) {
        TipoCitado model = tipoCitadoService.getById(uuid);
        return TipoCitadoMapper.toDto(model);
    }
}
