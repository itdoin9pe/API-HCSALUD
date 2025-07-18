package com.saludsystem.submodules.catalogo.service.consentimiento;

import com.saludsystem.submodules.catalogo.port.repository.ConsentimientoRepository;

import java.util.UUID;

public class ConsentimientoDeleteService {

    private final ConsentimientoRepository consentimientoRepository;

    public ConsentimientoDeleteService(ConsentimientoRepository consentimientoRepository) {
        this.consentimientoRepository = consentimientoRepository;
    }

    public void execute(UUID uuid) {
        consentimientoRepository.delete(uuid);
    }
}
