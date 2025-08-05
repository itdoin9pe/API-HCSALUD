package com.saludsystem.submodules.configuracion.mapper;

import com.saludsystem.submodules.configuracion.model.Sede;
import com.saludsystem.submodules.configuracion.model.dtos.SedeDTO;
import com.saludsystem.submodules.configuracion.model.dtos.command.SedeCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.edit.SedeEditCommand;

import java.util.UUID;

public class SedeMapper {

    public Sede fromCreateDto(SedeCreateCommand createCommand) {

        return new Sede(null, createCommand.getCodigo(), createCommand.getNombre(), createCommand.getDireccion(),
                createCommand.getUbigeo(), createCommand.getEstado());

    }

    public Sede fromUpdateDto(UUID uuid, SedeEditCommand editCommand) {

        return new Sede(null, editCommand.getCodigo(), editCommand.getNombre(), editCommand.getDireccion(),
                editCommand.getUbigeo(), editCommand.getEstado());

    }

    public SedeDTO toDto(Sede model) {

        return new SedeDTO(
                model.getCodigo(),
                model.getNombre(),
                model.getDireccion(),
                model.getUbigeo(),
                model.getEstado());

    }

}
