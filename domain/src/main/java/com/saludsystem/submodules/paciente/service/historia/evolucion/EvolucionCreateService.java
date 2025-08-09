package com.saludsystem.submodules.paciente.service.historia.evolucion;

import com.saludsystem.submodules.paciente.model.entity.evolucion.Evolucion;
import com.saludsystem.submodules.paciente.port.repository.evolucion.EvolucionRepository;

public class EvolucionCreateService {

    private final EvolucionRepository evolucionRepository;

    public EvolucionCreateService(EvolucionRepository evolucionRepository) {
        this.evolucionRepository = evolucionRepository;
    }

    public Evolucion execute(Evolucion evolucion) {

        return evolucionRepository.save(evolucion);

    }

}
