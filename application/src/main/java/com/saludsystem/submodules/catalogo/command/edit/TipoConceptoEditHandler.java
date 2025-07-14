package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dtos.put.ActualizarTipoConceptoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.port.in.service.TipoConceptoService;
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
