package com.saludsystem.submodules.paciente.command.edit.estadocuenta;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.EstadoCuentaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta.EstadoCuentaEditCommand;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.EstadoCuentaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EstadoCuentaEditHandler {

    private final EstadoCuentaEditService estadoCuentaEditService;
    private final EstadoCuentaMapper estadoCuentaMapper;

    public EstadoCuentaEditHandler(EstadoCuentaEditService estadoCuentaEditService, EstadoCuentaMapper estadoCuentaMapper) {
        this.estadoCuentaEditService = estadoCuentaEditService;
        this.estadoCuentaMapper = estadoCuentaMapper;
    }

    public void execute(UUID uuid, EstadoCuentaEditCommand editCommand) {

        var estadoCuentaUpdated = estadoCuentaMapper.fromUpdateDto(uuid, editCommand);

        estadoCuentaEditService.execute(uuid, estadoCuentaUpdated);

    }

}
