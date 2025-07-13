package com.saludsystem.application.catalogo.query.getAll;

import com.saludsystem.application.catalogo.dtos.get.TipoCitadoDTO;
import com.saludsystem.application.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.domain.catalogo.model.TipoCitado;
import com.saludsystem.domain.catalogo.port.in.service.TipoCitadoService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoCitadoAllHandler {
    private final TipoCitadoService tipoCitadoService;

    public TipoCitadoAllHandler(TipoCitadoService tipoCitadoService) {
        this.tipoCitadoService = tipoCitadoService;
    }

    public List<TipoCitadoDTO> execute(UUID hospitalId, int page, int rows) {
        List<TipoCitado> models = tipoCitadoService.getAll(hospitalId, page, rows);
        return models.stream().map(TipoCitadoMapper::toDto).toList();
    }
}
