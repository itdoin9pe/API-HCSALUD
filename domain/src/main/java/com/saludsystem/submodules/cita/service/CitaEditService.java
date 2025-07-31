package com.saludsystem.submodules.cita.service;

import com.saludsystem.submodules.cita.model.entity.Cita;
import com.saludsystem.submodules.cita.port.dao.CitaDao;
import com.saludsystem.submodules.cita.port.repository.CitaRepository;

import java.util.UUID;

public class CitaEditService {

    private final CitaDao citaDao;
    private final CitaRepository citaRepository;

    public CitaEditService(CitaDao citaDao, CitaRepository citaRepository) {
        this.citaDao = citaDao;
        this.citaRepository = citaRepository;
    }

    public Cita execute(UUID uuid, Cita cita) {

        var currentCita = citaDao.getById(uuid);

        if (currentCita.getEstado() != null && currentCita.getEstado() == "INACTIVE") {

            throw new IllegalStateException("La cita ya se encuentra desactivada");

        }

        return citaRepository.update(uuid, cita);

    }

}
