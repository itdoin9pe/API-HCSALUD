package com.saludsystem.submodules.mantenimiento.mapper;

import com.saludsystem.submodules.mantenimiento.model.Cuenta;
import com.saludsystem.submodules.mantenimiento.model.dtos.CuentaDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.CuentaCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.CuentaEditCommand;

import java.util.UUID;

public class CuentaMapper {

    public Cuenta fromCreateDto(CuentaCreateCommand createCommand) {
        return new Cuenta(null,
                createCommand.getNombre(), createCommand.getTotal(), createCommand.getEstado());
    }

    public Cuenta fromUpdateDto(UUID uuid, CuentaEditCommand editCommand) {
        return new Cuenta(uuid, editCommand.getNombre(), editCommand.getTotal(),
                editCommand.getEstado());
    }

    public CuentaDTO toDto(Cuenta model) {
        return new CuentaDTO(model.getId(), model.getNombre(), model.getTotal(), model.getEstado());
    }

}
