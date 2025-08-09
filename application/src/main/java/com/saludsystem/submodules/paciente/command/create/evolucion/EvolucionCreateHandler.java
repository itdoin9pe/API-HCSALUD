package com.saludsystem.submodules.paciente.command.create.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.EvolucionMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.EvolucionCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.evolucion.EvolucionCreateService;
import org.springframework.stereotype.Component;

@Component
public class EvolucionCreateHandler {

    private final EvolucionCreateService evolucionCreateService;
    private final EvolucionMapper evolucionMapper;

    public EvolucionCreateHandler(EvolucionCreateService evolucionCreateService, EvolucionMapper evolucionMapper) {
        this.evolucionCreateService = evolucionCreateService;
        this.evolucionMapper = evolucionMapper;
    }

    public void execute(EvolucionCreateCommand createCommand) {

        var evolucionSaved = evolucionMapper.fromCreateDto(createCommand);

        evolucionCreateService.execute(evolucionSaved);

    }

}
