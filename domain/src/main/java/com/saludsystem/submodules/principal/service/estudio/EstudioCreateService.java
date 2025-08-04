package com.saludsystem.submodules.principal.service.estudio;

import com.saludsystem.submodules.principal.model.Estudio;
import com.saludsystem.submodules.principal.port.repository.EstudioRepository;

public class EstudioCreateService {

    private final EstudioRepository estudioRepository;

    public EstudioCreateService(EstudioRepository estudioRepository) {
        this.estudioRepository = estudioRepository;
    }

    public Estudio execute(Estudio estudio) {

        return estudioRepository.save(estudio);

    }

}
