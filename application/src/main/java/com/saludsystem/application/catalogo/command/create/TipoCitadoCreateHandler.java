package com.saludsystem.application.catalogo.command.create;

import com.saludsystem.application.catalogo.dtos.post.CrearTipoCitadoDTO;
import com.saludsystem.application.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.domain.catalogo.port.in.service.TipoCitadoService;
import org.springframework.stereotype.Component;

@Component
public class TipoCitadoCreateHandler {

    private final TipoCitadoService tipoCitadoService;

    public TipoCitadoCreateHandler(TipoCitadoService tipoCitadoService) {
        this.tipoCitadoService = tipoCitadoService;
    }

    public void execute(CrearTipoCitadoDTO dto) {
        tipoCitadoService.save(TipoCitadoMapper.formCreatoDto(dto));
    }
}
