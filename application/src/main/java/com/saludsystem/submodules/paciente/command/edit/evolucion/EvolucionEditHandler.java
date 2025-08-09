package com.saludsystem.submodules.paciente.command.edit.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.EvolucionMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.EvolucionEditCommand;
import com.saludsystem.submodules.paciente.service.historia.evolucion.EvolucionEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EvolucionEditHandler {

    private final EvolucionEditService evolucionEditService;
    private final EvolucionMapper evolucionMapper;

    public EvolucionEditHandler(EvolucionEditService evolucionEditService, EvolucionMapper evolucionMapper) {
        this.evolucionEditService = evolucionEditService;
        this.evolucionMapper = evolucionMapper;
    }

    public void execute(UUID uuid, EvolucionEditCommand editCommand) {

        var evolucionUpdated = evolucionMapper.fromUpdateDto(uuid, editCommand);

        evolucionEditService.execute(uuid, evolucionUpdated);

    }

}
