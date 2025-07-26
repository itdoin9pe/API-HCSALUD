package com.saludsystem.submodules.principal.service.pais;

import com.saludsystem.submodules.principal.port.repository.PaisRepository;

public class PaisDeleteService {

    private final PaisRepository paisRepository;

    public PaisDeleteService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public void execute(Integer id) {
        paisRepository.delete(id);
    }

}
