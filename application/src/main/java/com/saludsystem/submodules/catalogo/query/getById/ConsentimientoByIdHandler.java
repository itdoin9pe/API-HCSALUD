package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dto.ConsentimientoDTO;
import com.saludsystem.submodules.catalogo.service.consentimiento.ConsentimientoByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoByIdHandler {

    private final ConsentimientoByIdService consentimientoByIdService;

    public ConsentimientoByIdHandler(ConsentimientoByIdService consentimientoByIdService) {
        this.consentimientoByIdService = consentimientoByIdService;
    }

    public ConsentimientoDTO execute(UUID uuid) {
        return consentimientoByIdService.execute(uuid);
    }
}