package com.saludsystem.submodules.paciente.command.create.tratamiento;

import com.saludsystem.submodules.paciente.mapper.tratamiento.ProcedimientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.tratamiento.ProcedimientoCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.procedimiento.ProcedimientoCreateService;
import org.springframework.stereotype.Component;

@Component
public class ProcedimientoCreateHandler {

    private final ProcedimientoCreateService procedimientoCreateService;
    private final ProcedimientoMapper procedimientoMapper;

    public ProcedimientoCreateHandler(ProcedimientoCreateService procedimientoCreateService, ProcedimientoMapper procedimientoMapper) {
        this.procedimientoCreateService = procedimientoCreateService;
        this.procedimientoMapper = procedimientoMapper;
    }

    public void execute(ProcedimientoCreateCommand createCommand) {

        var procedimientoSaved = procedimientoMapper.fromCreateDto(createCommand);

        procedimientoCreateService.execute(procedimientoSaved);

    }

}
