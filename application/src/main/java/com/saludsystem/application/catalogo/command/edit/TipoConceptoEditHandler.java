package com.saludsystem.application.catalogo.command.edit;

import com.saludsystem.application.catalogo.dtos.put.ActualizarTipoConceptoDTO;
import com.saludsystem.application.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.domain.catalogo.port.in.service.TipoConceptoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoConceptoEditHandler {
    private final TipoConceptoService tipoConceptoService;

    public TipoConceptoEditHandler(TipoConceptoService tipoConceptoService) {
        this.tipoConceptoService = tipoConceptoService;
    }

    public void execute(UUID uuid, ActualizarTipoConceptoDTO dto) {
        tipoConceptoService.update(uuid, TipoConceptoMapper.fromUpdateDto(uuid, dto));
    }
}
