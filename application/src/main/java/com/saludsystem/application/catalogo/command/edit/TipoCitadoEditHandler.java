package com.saludsystem.application.catalogo.command.edit;

import com.saludsystem.application.catalogo.dtos.put.ActualizarTipoCitadoDTO;
import com.saludsystem.application.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.domain.catalogo.port.in.service.TipoCitadoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoCitadoEditHandler {
    private final TipoCitadoService tipoCitadoService;

    public TipoCitadoEditHandler(TipoCitadoService tipoCitadoService) {
        this.tipoCitadoService = tipoCitadoService;
    }

    public void execute(UUID uuid, ActualizarTipoCitadoDTO dto) {
        tipoCitadoService.update(uuid, TipoCitadoMapper.fromUpdateDto(uuid, dto));
    }
}