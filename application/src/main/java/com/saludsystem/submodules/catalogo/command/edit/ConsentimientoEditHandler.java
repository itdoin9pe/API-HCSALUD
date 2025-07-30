package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dto.edit.ActualizarConsentimientoDTO;
import com.saludsystem.submodules.catalogo.service.consentimiento.ConsentimientoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoEditHandler {

    private final ConsentimientoEditService consentimientoEditService;

    public ConsentimientoEditHandler(ConsentimientoEditService consentimientoEditService) {
        this.consentimientoEditService = consentimientoEditService;
    }

    public void execute(UUID uuid, ActualizarConsentimientoDTO dto) {
        consentimientoEditService.execute(uuid, dto);
    }
}
