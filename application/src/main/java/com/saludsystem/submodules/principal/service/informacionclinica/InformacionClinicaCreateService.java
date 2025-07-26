package com.saludsystem.submodules.principal.service.informacionclinica;

import com.saludsystem.submodules.principal.mapper.InformacionClinicaMapper;
import com.saludsystem.submodules.principal.model.InformacionClinica;
import com.saludsystem.submodules.principal.model.dtos.post.CrearInformacionClinicaDTO;
import com.saludsystem.submodules.principal.port.repository.InformacionClinicaRepository;

public class InformacionClinicaCreateService {

    private final InformacionClinicaRepository informacionClinicaRepository;

    public InformacionClinicaCreateService(InformacionClinicaRepository informacionClinicaRepository) {
        this.informacionClinicaRepository = informacionClinicaRepository;
    }

    public InformacionClinica execute(CrearInformacionClinicaDTO dto) {

        var saved = InformacionClinicaMapper.fromCreateDto(dto);

        return informacionClinicaRepository.save(saved);

    }

}
