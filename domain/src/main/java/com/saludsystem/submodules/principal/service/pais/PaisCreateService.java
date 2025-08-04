package com.saludsystem.submodules.principal.service.pais;

import com.saludsystem.submodules.principal.model.Pais;
import com.saludsystem.submodules.principal.port.repository.PaisRepository;

public class PaisCreateService {

    private final PaisRepository paisRepository;

    public PaisCreateService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public Pais execute(Pais pais) {

        return paisRepository.save(pais);

    }

}
