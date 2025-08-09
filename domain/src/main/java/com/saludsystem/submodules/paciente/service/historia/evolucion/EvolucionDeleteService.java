package com.saludsystem.submodules.paciente.service.historia.evolucion;

import com.saludsystem.submodules.paciente.port.dao.evolucion.EvolucionDao;
import com.saludsystem.submodules.paciente.port.repository.evolucion.EvolucionRepository;

import java.util.UUID;

public class EvolucionDeleteService {

    private final EvolucionRepository evolucionRepository;
    private final EvolucionDao evolucionDao;

    public EvolucionDeleteService(EvolucionRepository evolucionRepository, EvolucionDao evolucionDao) {
        this.evolucionRepository = evolucionRepository;
        this.evolucionDao = evolucionDao;
    }

    public void execute(UUID uuid) {

        var evolucion = evolucionDao.getById(uuid);

        if (evolucion.getFinalizada() != null) {

            throw new IllegalStateException("No se puede eliminar la evolucion del paciente sin informe final");

        }

        evolucionRepository.delete(uuid);

    }

}
