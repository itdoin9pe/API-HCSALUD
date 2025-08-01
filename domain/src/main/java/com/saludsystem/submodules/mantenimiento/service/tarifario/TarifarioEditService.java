package com.saludsystem.submodules.mantenimiento.service.tarifario;

import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.mantenimiento.port.dao.TarifarioDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TarifarioRepository;

import java.util.UUID;

public class TarifarioEditService {

    private final TarifarioDao tarifarioDao;
    private final TarifarioRepository tarifarioRepository;

    public TarifarioEditService(TarifarioDao tarifarioDao, TarifarioRepository tarifarioRepository) {
        this.tarifarioDao = tarifarioDao;
        this.tarifarioRepository = tarifarioRepository;
    }

    public Tarifario execute(UUID uuid, Tarifario tarifario) {

        var currentTarifario = tarifarioDao.getById(uuid);

        if (currentTarifario.getEstado() != null && currentTarifario.getEstado() == 0) {

            throw new IllegalStateException("El tipo de tarifario ya se encuentra desactivado");

        }

        return tarifarioRepository.update(uuid, tarifario);

    }

}
