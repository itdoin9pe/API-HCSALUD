package com.saludsystem.application.catalogo.query.getAll;

import com.saludsystem.application.catalogo.dtos.get.TipoConceptoDTO;
import com.saludsystem.application.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.domain.catalogo.model.TipoConcepto;
import com.saludsystem.domain.catalogo.port.in.service.TipoConceptoService;
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
