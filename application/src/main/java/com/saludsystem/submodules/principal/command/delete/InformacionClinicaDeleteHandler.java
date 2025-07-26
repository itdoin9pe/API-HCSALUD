package com.saludsystem.submodules.principal.command.delete;

import com.saludsystem.submodules.principal.service.informacionclinica.InformacionClinicaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InformacionClinicaDeleteHandler {

    private final InformacionClinicaDeleteService informacionClinicaDeleteService;

    public InformacionClinicaDeleteHandler(InformacionClinicaDeleteService informacionClinicaDeleteService) {
        this.informacionClinicaDeleteService = informacionClinicaDeleteService;
    }

    public void execute(UUID uuid) {
        informacionClinicaDeleteService.execute(uuid);
    }

}
