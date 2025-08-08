package com.saludsystem.submodules.configuracion.mapper;

import com.saludsystem.submodules.configuracion.model.SysSalud;
import com.saludsystem.submodules.configuracion.model.dtos.ClinicaDTO;
import com.saludsystem.submodules.configuracion.model.dtos.command.ClinicaCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.ClinicaEditCommand;

import java.util.UUID;

public class ClinicaMapper {

    public SysSalud fromCreateDto(ClinicaCreateCommand createCommand) {

        return new SysSalud(null, createCommand.getNombre(), createCommand.getDireccion(),
                createCommand.getCelular(), createCommand.getEmail(),
                createCommand.getRuc(), createCommand.getFecha(), createCommand.getFoto(),
                createCommand.getEstado(), createCommand.getPlanId());

    }

    public SysSalud fromUpdateDto(UUID uuid, ClinicaEditCommand editCommand) {

        return new SysSalud(uuid, editCommand.getNombre(), editCommand.getDireccion(),
                editCommand.getCelular(), editCommand.getEmail(),
                editCommand.getRuc(), editCommand.getFecha(), editCommand.getFoto(),
                editCommand.getEstado(), editCommand.getPlanId());

    }

    public ClinicaDTO toDto(SysSalud model) {

        return new ClinicaDTO(
                model.getId(),
                model.getNombre(),
                model.getDireccion(),
                model.getCelular(),
                model.getEmail(),
                model.getRuc(),
                model.getFecha(),
                model.getFoto(),
                model.getPlanId(),
                model.getEstado());

    }

}
