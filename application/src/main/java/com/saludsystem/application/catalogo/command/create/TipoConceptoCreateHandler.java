package com.saludsystem.application.catalogo.command.create;

import com.saludsystem.application.catalogo.dtos.post.CrearTipoConceptoDTO;
import com.saludsystem.application.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.domain.catalogo.port.in.service.TipoConceptoService;
import org.springframework.stereotype.Component;

@Component
public class TipoConceptoCreateHandler {

    private final TipoConceptoService tipoConceptoService;

    public TipoConceptoCreateHandler(TipoConceptoService tipoConceptoService) {
        this.tipoConceptoService = tipoConceptoService;
    }

    public void execute(CrearTipoConceptoDTO dto) {
        tipoConceptoService.save(TipoConceptoMapper.fromCreateDto(dto));
    }
}
