package com.saludsystem.submodules.principal.mapper;

import com.saludsystem.submodules.principal.model.InformacionClinica;
import com.saludsystem.submodules.principal.model.dtos.get.InformacionClinicaDTO;
import com.saludsystem.submodules.principal.model.dtos.post.CrearInformacionClinicaDTO;
import com.saludsystem.submodules.principal.model.dtos.put.ActualizarInformacionClinicaDTO;

import java.util.UUID;

public class InformacionClinicaMapper {

    public static InformacionClinica fromCreateDto(CrearInformacionClinicaDTO dto) {
        return new InformacionClinica(null, dto.getNombre(), dto.getEstado());
    }

    public static InformacionClinica fromUpdateDto(UUID id, ActualizarInformacionClinicaDTO dto) {
        return new InformacionClinica(id, dto.getNombre(), dto.getEstado());
    }

    public static InformacionClinicaDTO toDto(InformacionClinica model) {
        return new InformacionClinicaDTO(
                model.getId(),
                model.getNombre(),
                model.getEstado());
    }
}
