package com.saludsystem.submodules.principal.service.estudio;

import com.saludsystem.submodules.principal.port.repository.EstudioRepository;

import java.util.UUID;

public class EstudioDeleteService {

    private final EstudioRepository estudioRepository;

    public EstudioDeleteService(EstudioRepository estudioRepository) {
        this.estudioRepository = estudioRepository;
    }

    public void execute(UUID uuid) {
        estudioRepository.delete(uuid);
    }

}
