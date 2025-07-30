package com.saludsystem.submodules.principal.query.getById;

import com.saludsystem.submodules.principal.dtos.get.InformacionClinicaDTO;
import com.saludsystem.submodules.principal.service.informacionclinica.InformacionClinicaByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InformacionClinicaByIdHandler {

    private final InformacionClinicaByIdService informacionClinicaByIdService;

    public InformacionClinicaByIdHandler(InformacionClinicaByIdService informacionClinicaByIdService) {
        this.informacionClinicaByIdService = informacionClinicaByIdService;
    }

    public InformacionClinicaDTO execute(UUID uuid) {
        return informacionClinicaByIdService.execute(uuid);
    }

}
