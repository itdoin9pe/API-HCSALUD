package com.saludsystem.application.catalogo.query.getById;

import com.saludsystem.application.catalogo.dtos.get.TipoCitadoDTO;
import com.saludsystem.application.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.domain.catalogo.model.TipoCitado;
import com.saludsystem.domain.catalogo.port.in.service.TipoCitadoService;
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
