package com.saludsystem.submodules.operaciones.mapper;

import com.saludsystem.submodules.operaciones.model.Presentacion;
import com.saludsystem.submodules.operaciones.model.dtos.PresentacionDTO;
import com.saludsystem.submodules.operaciones.model.dtos.command.PresentacionCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.PresentacionEditCommand;

import java.util.UUID;

public class PresentacionMapper {

    public Presentacion fromCreateDto(PresentacionCreateCommand createCommand) {

        return new Presentacion(null, createCommand.getNombre(), createCommand.getEstado());

    }

    public Presentacion fromUpdateDto(UUID uuid, PresentacionEditCommand editCommand) {

        return new Presentacion(uuid, editCommand.getNombre(), editCommand.getEstado());

    }

    public PresentacionDTO toDto(Presentacion presentacion) {

        return new PresentacionDTO(
                presentacion.getId(),
                presentacion.getNombre(),
                presentacion.getEstado());

    }

}
