package com.saludsystem.submodules.principal.service.estudio;

import com.saludsystem.submodules.principal.model.Estudio;
import com.saludsystem.submodules.principal.model.constant.EstudioConstant;
import com.saludsystem.submodules.principal.port.dao.EstudioDao;
import com.saludsystem.submodules.principal.port.repository.EstudioRepository;

import java.util.UUID;

public class EstudioEditService {

    private final EstudioDao estudioDao;
    private final EstudioRepository estudioRepository;

    public EstudioEditService(EstudioDao estudioDao, EstudioRepository estudioRepository) {
        this.estudioDao = estudioDao;
        this.estudioRepository = estudioRepository;
    }

    public Estudio execute(UUID uuid, Estudio estudio) {

        var currentEstudio = estudioDao.getById(uuid);

        if (currentEstudio == null) {
            throw new IllegalArgumentException(EstudioConstant.ID_NOT_FOUND);
        }

        if (currentEstudio.getDescripcion() != null && currentEstudio.getDescripcion() == "EMPTY") {
            throw new IllegalStateException("El estudio ya se encuentra vacio");
        }

        return estudioRepository.update(uuid, estudio);

    }

}
