package com.saludsystem.submodules.catalogo.service.medida;

import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.port.repository.MedidaRepository;

public class MedidaCreateService {

    private final MedidaRepository medidaRepository;

    public MedidaCreateService(MedidaRepository medidaRepository) {
        this.medidaRepository = medidaRepository;
    }

    public Medida execute(Medida model) {
        return medidaRepository.save(model);
    }

}
