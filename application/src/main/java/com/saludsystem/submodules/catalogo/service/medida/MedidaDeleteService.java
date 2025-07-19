package com.saludsystem.submodules.catalogo.service.medida;

import com.saludsystem.submodules.catalogo.port.repository.MedidaRepository;

import java.util.UUID;

public class MedidaDeleteService {

    private final MedidaRepository medidaRepository;

    public MedidaDeleteService(MedidaRepository medidaRepository) {
        this.medidaRepository = medidaRepository;
    }

    public void execute(UUID uuid) {
        medidaRepository.delete(uuid);
    }
}
