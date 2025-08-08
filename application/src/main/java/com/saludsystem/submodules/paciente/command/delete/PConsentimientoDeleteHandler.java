package com.saludsystem.submodules.paciente.command.delete;

import com.saludsystem.submodules.paciente.service.fichaclinica.pconsentimiento.PConsentimientoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PConsentimientoDeleteHandler {

    private final PConsentimientoDeleteService pConsentimientoDeleteService;

    public PConsentimientoDeleteHandler(PConsentimientoDeleteService pConsentimientoDeleteService) {
        this.pConsentimientoDeleteService = pConsentimientoDeleteService;
    }

    public void execute(UUID uuid) {

        pConsentimientoDeleteService.execute(uuid);

    }

}
