package com.saludsystem.submodules.catalogo.service.alergia;

import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import com.saludsystem.submodules.catalogo.port.repository.AlergiaRepository;

import java.util.UUID;

public class AlergiaEditService {

    private final AlergiaDao alergiaDao;
    private final AlergiaRepository alergiaRepository;

    public AlergiaEditService(AlergiaDao alergiaDao, AlergiaRepository alergiaRepository) {
        this.alergiaDao = alergiaDao;
        this.alergiaRepository = alergiaRepository;
    }

    public Alergia execute(UUID uuid, Alergia alergia) {

        var currentAlergia = alergiaDao.getById(uuid);

        if (currentAlergia.getEstado() != null && currentAlergia.getEstado() == 0) {
            throw new IllegalStateException("La alergia ya se encuentra desactivada");
        }

        return alergiaRepository.update(uuid, alergia);

    }

}
