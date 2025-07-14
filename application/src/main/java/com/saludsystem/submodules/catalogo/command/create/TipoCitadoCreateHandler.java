package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.dtos.post.CrearTipoCitadoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.port.in.service.TipoCitadoService;
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
