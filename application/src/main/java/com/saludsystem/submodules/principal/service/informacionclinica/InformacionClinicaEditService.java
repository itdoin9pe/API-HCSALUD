package com.saludsystem.submodules.principal.service.informacionclinica;

import com.saludsystem.submodules.principal.mapper.InformacionClinicaMapper;
import com.saludsystem.submodules.principal.model.InformacionClinica;
import com.saludsystem.submodules.principal.dtos.put.ActualizarInformacionClinicaDTO;
import com.saludsystem.submodules.principal.port.repository.InformacionClinicaRepository;

import java.util.UUID;

public class InformacionClinicaEditService {

    private final InformacionClinicaRepository informacionClinicaRepository;

    public InformacionClinicaEditService(InformacionClinicaRepository informacionClinicaRepository) {
        this.informacionClinicaRepository = informacionClinicaRepository;
    }

    public InformacionClinica execute(UUID uuid, ActualizarInformacionClinicaDTO dto) {

        var updated = InformacionClinicaMapper.fromUpdateDto(uuid, dto);

        return informacionClinicaRepository.update(uuid, updated);

    }

}
