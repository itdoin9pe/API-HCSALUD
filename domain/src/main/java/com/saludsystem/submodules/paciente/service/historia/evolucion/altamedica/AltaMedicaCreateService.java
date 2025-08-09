package com.saludsystem.submodules.paciente.service.historia.evolucion.altamedica;

import com.saludsystem.submodules.paciente.model.entity.evolucion.AltaMedica;
import com.saludsystem.submodules.paciente.port.repository.evolucion.AltaMedicaRepository;

public class AltaMedicaCreateService {

    private final AltaMedicaRepository altaMedicaRepository;

    public AltaMedicaCreateService(AltaMedicaRepository altaMedicaRepository) {
        this.altaMedicaRepository = altaMedicaRepository;
    }

    public AltaMedica execute(AltaMedica altaMedica) {

        return altaMedicaRepository.save(altaMedica);

    }
}
