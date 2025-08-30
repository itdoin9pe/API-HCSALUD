package com.saludsystem.submodules.cita.service;

import com.saludsystem.submodules.cita.model.Cita;
import com.saludsystem.submodules.cita.port.repository.CitaRepository;

public class CitaCreateService {

    private final CitaRepository citaRepository;

    public CitaCreateService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public Cita execute(Cita cita) {

        return citaRepository.save(cita);

    }

}
