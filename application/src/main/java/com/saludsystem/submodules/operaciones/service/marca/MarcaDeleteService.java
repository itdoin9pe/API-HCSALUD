package com.saludsystem.submodules.operaciones.service.marca;

import com.saludsystem.submodules.operaciones.port.repository.MarcaRepository;

import java.util.UUID;

public class MarcaDeleteService {

    private final MarcaRepository marcaRepository;

    public MarcaDeleteService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public void execute(UUID uuid) {
        marcaRepository.delete(uuid);
    }

}
