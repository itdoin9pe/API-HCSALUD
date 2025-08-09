package com.saludsystem.submodules.paciente.command.edit.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.AltaMedicaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.AltaMedicaEditCommand;
import com.saludsystem.submodules.paciente.service.historia.evolucion.altamedica.AltaMedicaEditService;
import org.springframework.stereotype.Component;

@Component
public class AltaMedicaEditHandler {

    private final AltaMedicaEditService altaMedicaEditService;
    private final AltaMedicaMapper altaMedicaMapper;

    public AltaMedicaEditHandler(AltaMedicaEditService altaMedicaEditService, AltaMedicaMapper altaMedicaMapper) {
        this.altaMedicaEditService = altaMedicaEditService;
        this.altaMedicaMapper = altaMedicaMapper;
    }

    public void execute(Long id, AltaMedicaEditCommand editCommand) {

        var altaMedicaUpdated = altaMedicaMapper.fromUpdateDto(id, editCommand);

        altaMedicaEditService.execute(id, altaMedicaUpdated);

    }

}
