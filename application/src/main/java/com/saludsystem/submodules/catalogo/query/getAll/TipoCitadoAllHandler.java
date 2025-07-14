package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.dtos.get.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.catalogo.port.in.service.TipoCitadoService;
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
