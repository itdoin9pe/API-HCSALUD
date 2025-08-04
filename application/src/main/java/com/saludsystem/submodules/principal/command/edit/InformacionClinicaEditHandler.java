package com.saludsystem.submodules.principal.command.edit;

import com.saludsystem.submodules.principal.mapper.InformacionClinicaMapper;
import com.saludsystem.submodules.principal.model.dtos.edit.InformacionClinicaEditCommand;
import com.saludsystem.submodules.principal.service.informacionclinica.InformacionClinicaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InformacionClinicaEditHandler {

    private final InformacionClinicaEditService informacionClinicaEditService;
    private final InformacionClinicaMapper informacionClinicaMapper;

    public InformacionClinicaEditHandler(InformacionClinicaEditService informacionClinicaEditService, InformacionClinicaMapper informacionClinicaMapper) {
        this.informacionClinicaEditService = informacionClinicaEditService;
        this.informacionClinicaMapper = informacionClinicaMapper;
    }

    public void execute(UUID uuid, InformacionClinicaEditCommand editCommand) {

        var infoClinicaUpdated = informacionClinicaMapper.fromUpdateDto(uuid, editCommand);

        informacionClinicaEditService.execute(uuid, infoClinicaUpdated);

    }

}
