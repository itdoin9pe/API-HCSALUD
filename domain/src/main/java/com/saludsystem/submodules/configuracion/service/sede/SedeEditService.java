package com.saludsystem.submodules.configuracion.service.sede;

import com.saludsystem.submodules.configuracion.model.Sede;
import com.saludsystem.submodules.configuracion.model.constant.SedeConstant;
import com.saludsystem.submodules.configuracion.port.in.dao.SedeDao;
import com.saludsystem.submodules.configuracion.port.in.repository.SedeRepository;

import java.util.UUID;

public class SedeEditService {

    private final SedeDao sedeDao;
    private final SedeRepository sedeRepository;

    public SedeEditService(SedeDao sedeDao, SedeRepository sedeRepository) {
        this.sedeDao = sedeDao;
        this.sedeRepository = sedeRepository;
    }

    public Sede execute(UUID uuid, Sede sede) {

        var currentSede = sedeDao.getById(uuid);

        if (currentSede == null) {

            throw new IllegalArgumentException(SedeConstant.ID_NOT_FOUND);

        }

        if (currentSede.getEstado() != null && currentSede.getEstado() == 0) {

            throw new IllegalStateException("La sede ya se encuentra desactivada");

        }

        return sedeRepository.update(uuid, sede);

    }

}
