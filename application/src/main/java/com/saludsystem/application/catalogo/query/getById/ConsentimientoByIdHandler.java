package com.saludsystem.application.catalogo.query.getById;

import com.saludsystem.application.catalogo.dtos.get.ConsentimientoDTO;
import com.saludsystem.application.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.domain.catalogo.model.Consentimiento;
import com.saludsystem.domain.catalogo.port.in.service.ConsentimientoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoByIdHandler {

    private final ConsentimientoService consentimientoService;

    public ConsentimientoByIdHandler(ConsentimientoService consentimientoService) {
        this.consentimientoService = consentimientoService;
    }

    public ConsentimientoDTO execute(UUID uuid) {
        Consentimiento model = consentimientoService.getById(uuid);
        return ConsentimientoMapper.toDto(model);
    }
}