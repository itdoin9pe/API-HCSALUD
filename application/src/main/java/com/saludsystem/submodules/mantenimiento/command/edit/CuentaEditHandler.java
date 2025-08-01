package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.mapper.CuentaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.CuentaEditCommand;
import com.saludsystem.submodules.mantenimiento.service.cuenta.CuentaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CuentaEditHandler {

    private final CuentaEditService cuentaEditService;
    private final CuentaMapper cuentaMapper;

    public CuentaEditHandler(CuentaEditService cuentaEditService, CuentaMapper cuentaMapper) {
        this.cuentaEditService = cuentaEditService;
        this.cuentaMapper = cuentaMapper;
    }

    public void execute(UUID uuid, CuentaEditCommand editCommand) {

        var cuenta = cuentaMapper.fromUpdateDto(uuid, editCommand);

        cuentaEditService.execute(uuid, cuenta);

    }

}
