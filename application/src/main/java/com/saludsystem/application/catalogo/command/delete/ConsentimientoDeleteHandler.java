package com.saludsystem.application.catalogo.command.delete;

import com.saludsystem.domain.catalogo.port.in.service.ConsentimientoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoDeleteHandler {

    private final ConsentimientoService consentimientoService;

    public ConsentimientoDeleteHandler(ConsentimientoService consentimientoService) {
        this.consentimientoService = consentimientoService;
    }

    public void execute(UUID uuid) {
        consentimientoService.delete(uuid);
    }
}