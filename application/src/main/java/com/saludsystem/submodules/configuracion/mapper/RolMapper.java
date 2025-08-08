package com.saludsystem.submodules.configuracion.mapper;

import com.saludsystem.submodules.configuracion.model.Rol;
import com.saludsystem.submodules.configuracion.model.dtos.RolDTO;
import com.saludsystem.submodules.configuracion.model.dtos.command.RolCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.RolEditCommand;

import java.util.UUID;

public class RolMapper {

    public Rol fromCreateDto(RolCreateCommand createCommand) {

        return new Rol(null, createCommand.getNombre(), createCommand.getEstado());

    }

    public Rol fromUpdateDto(UUID uuid, RolEditCommand editCommand) {

        return new Rol(uuid, editCommand.getNombre(), editCommand.getEstado());

    }

    public RolDTO toDto(Rol model) {

        return new RolDTO(
                model.getRoleId(),
                model.getEstado(),
                model.getNombre());

    }

}
