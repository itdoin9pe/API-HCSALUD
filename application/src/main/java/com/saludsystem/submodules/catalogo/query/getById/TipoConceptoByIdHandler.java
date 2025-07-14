package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dtos.get.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.port.in.service.TipoConceptoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoConceptoByIdHandler {
    public final TipoConceptoService tipoConceptoService;

    public TipoConceptoByIdHandler(TipoConceptoService tipoConceptoService) {
        this.tipoConceptoService = tipoConceptoService;
    }

    public TipoConceptoDTO execute(UUID uuid) {
        TipoConcepto model = tipoConceptoService.getById(uuid);
        return TipoConceptoMapper.toDto(model);
    }
}
