package com.saludsystem.application.catalogo.command.edit;

import com.saludsystem.application.catalogo.dtos.put.ActualizarConsentimientoDTO;
import com.saludsystem.application.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.domain.catalogo.port.in.service.ConsentimientoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoEditHandler {

    private final ConsentimientoService consentimientoService;

    public ConsentimientoEditHandler(ConsentimientoService consentimientoService) {
        this.consentimientoService = consentimientoService;
    }

    public void execute(UUID uuid, ActualizarConsentimientoDTO dto) {
        consentimientoService.update(uuid, ConsentimientoMapper.fromUpdateDto(uuid, dto));
    }
}
