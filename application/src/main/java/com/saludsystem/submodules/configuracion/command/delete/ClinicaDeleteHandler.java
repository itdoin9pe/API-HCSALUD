package com.saludsystem.submodules.configuracion.command.delete;

import com.saludsystem.submodules.configuracion.service.clinica.ClinicaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClinicaDeleteHandler {

    private final ClinicaDeleteService clinicaDeleteService;

    public ClinicaDeleteHandler(ClinicaDeleteService clinicaDeleteService) {
        this.clinicaDeleteService = clinicaDeleteService;
    }

    public void execute(UUID uuid) {

        clinicaDeleteService.execute(uuid);

    }

}
