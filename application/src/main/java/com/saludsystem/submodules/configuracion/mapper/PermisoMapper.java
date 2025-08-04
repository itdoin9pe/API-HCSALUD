package com.saludsystem.submodules.configuracion.mapper;

import com.saludsystem.submodules.configuracion.model.Permiso;
import com.saludsystem.submodules.configuracion.model.dtos.PermisoDTO;
import com.saludsystem.submodules.configuracion.model.dtos.command.PermisoCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.edit.PermisoEditCommand;

import java.util.UUID;

public class PermisoMapper {

    public Permiso fromCreateDto(PermisoCreateCommand createCommand) {

        return new Permiso(null, createCommand.getInsert(), createCommand.getRead(),
                createCommand.getUpdate(), createCommand.getDelete(),
                createCommand.getRolId(), createCommand.getRolId());

    }

    public Permiso fromUpdateDto(UUID uuid, PermisoEditCommand editCommand) {

        return new Permiso(uuid, editCommand.getInsert(), editCommand.getRead(),
                editCommand.getUpdate(), editCommand.getDelete(),
                editCommand.getRolId(), editCommand.getRolId());

    }


    public PermisoDTO toDto(Permiso model) {

        return new PermisoDTO(
                model.getId(),
                model.getInsert(),
                model.getRead(),
                model.getUpdate(),
                model.getDelete(),
                model.getRolId(),
                model.getMenuId());

    }

}
