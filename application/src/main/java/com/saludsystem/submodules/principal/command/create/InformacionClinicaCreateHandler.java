package com.saludsystem.submodules.principal.command.create;

import com.saludsystem.submodules.principal.dtos.post.CrearInformacionClinicaDTO;
import com.saludsystem.submodules.principal.service.informacionclinica.InformacionClinicaCreateService;
import org.springframework.stereotype.Component;

@Component
public class InformacionClinicaCreateHandler {

    private final InformacionClinicaCreateService informacionClinicaCreateService;

    public InformacionClinicaCreateHandler(InformacionClinicaCreateService informacionClinicaCreateService) {
        this.informacionClinicaCreateService = informacionClinicaCreateService;
    }

    public void execute(CrearInformacionClinicaDTO dto) {
        informacionClinicaCreateService.execute(dto);
    }

}
