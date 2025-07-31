package com.saludsystem.submodules.cita.service;

import com.saludsystem.submodules.cita.port.dao.CitaDao;
import com.saludsystem.submodules.cita.port.repository.CitaRepository;

import java.util.UUID;

public class CitaDeleteService {

    private final CitaRepository citaRepository;
    private final CitaDao citaDao;

    public CitaDeleteService(CitaRepository citaRepository, CitaDao citaDao) {
        this.citaRepository = citaRepository;
        this.citaDao = citaDao;
    }

    public void execute(UUID uuid) {

        var cita = citaDao.getById(uuid);

        if (cita.getEstado() != null && cita.getEstado() == "INACTIVE") {
            throw new IllegalStateException("No se puede eliminar una cita ya desactivada");
        }

        citaRepository.delete(uuid);

    }

}
