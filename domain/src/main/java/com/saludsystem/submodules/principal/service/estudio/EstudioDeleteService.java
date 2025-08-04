package com.saludsystem.submodules.principal.service.estudio;

import com.saludsystem.submodules.principal.port.dao.EstudioDao;
import com.saludsystem.submodules.principal.port.repository.EstudioRepository;

import java.util.UUID;

public class EstudioDeleteService {

    private final EstudioRepository estudioRepository;
    private final EstudioDao estudioDao;

    public EstudioDeleteService(EstudioRepository estudioRepository, EstudioDao estudioDao) {
        this.estudioRepository = estudioRepository;
        this.estudioDao = estudioDao;
    }

    public void execute(UUID uuid) {

        var estudio = estudioDao.getById(uuid);

        if (estudio.getDescripcion() != null && estudio.getDescripcion() == "EMPTY") {
            throw new IllegalStateException("No se puede eliminar un estudio vacio");
        }

        estudioRepository.delete(uuid);

    }

}
