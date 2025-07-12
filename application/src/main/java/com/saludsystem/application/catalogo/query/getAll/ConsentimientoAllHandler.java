package com.saludsystem.application.catalogo.query.getAll;

import com.saludsystem.application.catalogo.dtos.get.ConsentimientoDTO;
import com.saludsystem.application.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.domain.catalogo.model.Consentimiento;
import com.saludsystem.domain.catalogo.port.in.service.ConsentimientoService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ConsentimientoAllHandler {

    private final ConsentimientoService consentimientoService;

    public ConsentimientoAllHandler(ConsentimientoService consentimientoService) {
        this.consentimientoService = consentimientoService;
    }

    public List<ConsentimientoDTO> execute(UUID hospitalId, int page, int rows) {
        List<Consentimiento> models = consentimientoService.getAll(hospitalId, page, rows);
        return models.stream().map(ConsentimientoMapper::toDto).toList();
    }
}