package com.saludsystem.submodules.principal.service.informacionclinica;

import com.saludsystem.submodules.principal.port.repository.InformacionClinicaRepository;

import java.util.UUID;

public class InformacionClinicaDeleteService {

    private final InformacionClinicaRepository informacionClinicaRepository;

    public InformacionClinicaDeleteService(InformacionClinicaRepository informacionClinicaRepository) {
        this.informacionClinicaRepository = informacionClinicaRepository;
    }

    public void execute(UUID uuid) {
        informacionClinicaRepository.delete(uuid);
    }

}
