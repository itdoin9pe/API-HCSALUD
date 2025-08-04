package com.saludsystem.submodules.principal.mapper;

import com.saludsystem.submodules.principal.model.InformacionClinica;
import com.saludsystem.submodules.principal.model.dtos.InformacionClinicaDTO;
import com.saludsystem.submodules.principal.model.dtos.command.InformacionClinicaCreateCommand;
import com.saludsystem.submodules.principal.model.dtos.edit.InformacionClinicaEditCommand;

import java.util.UUID;

public class InformacionClinicaMapper {

    public InformacionClinica fromCreateDto(InformacionClinicaCreateCommand dto) {
        return new InformacionClinica(null, dto.getNombre(), dto.getEstado());
    }

    public InformacionClinica fromUpdateDto(UUID id, InformacionClinicaEditCommand dto) {
        return new InformacionClinica(id, dto.getNombre(), dto.getEstado());
    }

    public InformacionClinicaDTO toDto(InformacionClinica model) {
        return new InformacionClinicaDTO(
                model.getId(),
                model.getNombre(),
                model.getEstado());
    }
}
