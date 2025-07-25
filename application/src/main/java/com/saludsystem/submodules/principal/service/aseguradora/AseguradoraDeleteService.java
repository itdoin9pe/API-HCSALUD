package com.saludsystem.submodules.principal.service.aseguradora;

import com.saludsystem.submodules.principal.port.repository.AseguradoraRepository;

import java.util.UUID;

public class AseguradoraDeleteService {

    private final AseguradoraRepository aseguradoraRepository;

    public AseguradoraDeleteService(AseguradoraRepository aseguradoraRepository) {
        this.aseguradoraRepository = aseguradoraRepository;
    }

    public void execute(UUID uuid) {
        aseguradoraRepository.delete(uuid);
    }

}
