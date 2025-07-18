package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.service.consentimiento.ConsentimientoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoDeleteHandler {

    private final ConsentimientoDeleteService consentimientoDeleteService;

    public ConsentimientoDeleteHandler(ConsentimientoDeleteService consentimientoDeleteService) {
        this.consentimientoDeleteService = consentimientoDeleteService;
    }

    public void execute(UUID uuid) {
        consentimientoDeleteService.execute(uuid);
    }
}