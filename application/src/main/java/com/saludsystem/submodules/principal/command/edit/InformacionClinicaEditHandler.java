package com.saludsystem.submodules.principal.command.edit;

import com.saludsystem.submodules.principal.dtos.put.ActualizarInformacionClinicaDTO;
import com.saludsystem.submodules.principal.service.informacionclinica.InformacionClinicaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InformacionClinicaEditHandler {

    private final InformacionClinicaEditService informacionClinicaEditService;

    public InformacionClinicaEditHandler(InformacionClinicaEditService informacionClinicaEditService) {
        this.informacionClinicaEditService = informacionClinicaEditService;
    }

    public void execute(UUID uuid, ActualizarInformacionClinicaDTO dto) {
        informacionClinicaEditService.execute(uuid, dto);
    }

}
