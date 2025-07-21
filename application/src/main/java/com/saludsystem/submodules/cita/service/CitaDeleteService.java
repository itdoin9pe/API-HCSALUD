package com.saludsystem.submodules.cita.service;

import com.saludsystem.submodules.cita.port.repository.CitaRepository;

import java.util.UUID;

public class CitaDeleteService {

    private final CitaRepository citaRepository;

    public CitaDeleteService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public void execute(UUID uuid) {
        citaRepository.delete(uuid);
    }
}
