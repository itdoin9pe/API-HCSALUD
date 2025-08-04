package com.saludsystem.submodules.principal.command.create;

import com.saludsystem.submodules.principal.mapper.InformacionClinicaMapper;
import com.saludsystem.submodules.principal.model.dtos.command.InformacionClinicaCreateCommand;
import com.saludsystem.submodules.principal.service.informacionclinica.InformacionClinicaCreateService;
import org.springframework.stereotype.Component;

@Component
public class InformacionClinicaCreateHandler {

    private final InformacionClinicaCreateService informacionClinicaCreateService;
    private final InformacionClinicaMapper informacionClinicaMapper;

    public InformacionClinicaCreateHandler(InformacionClinicaCreateService informacionClinicaCreateService, InformacionClinicaMapper informacionClinicaMapper) {
        this.informacionClinicaCreateService = informacionClinicaCreateService;
        this.informacionClinicaMapper = informacionClinicaMapper;
    }

    public void execute(InformacionClinicaCreateCommand createCommand) {

        var infoClinicaSaved = informacionClinicaMapper.fromCreateDto(createCommand);

        informacionClinicaCreateService.execute(infoClinicaSaved);

    }

}
