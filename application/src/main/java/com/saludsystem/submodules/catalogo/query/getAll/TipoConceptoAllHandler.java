package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.dtos.get.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.port.in.service.TipoConceptoService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoConceptoAllHandler {
    private final TipoConceptoService tipoConceptoService;

    public TipoConceptoAllHandler(TipoConceptoService tipoConceptoService) {
        this.tipoConceptoService = tipoConceptoService;
    }

    public List<TipoConceptoDTO> execute(UUID hospitalId, int page, int rows) {
        List<TipoConcepto> models = tipoConceptoService.getAll(hospitalId, page, rows);
        return models.stream().map(TipoConceptoMapper::toDto).toList();
    }
}
