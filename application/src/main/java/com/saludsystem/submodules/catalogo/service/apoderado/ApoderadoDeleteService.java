package com.saludsystem.submodules.catalogo.service.apoderado;

import com.saludsystem.submodules.catalogo.port.repository.ApoderadoRepository;

import java.util.UUID;

public class ApoderadoDeleteService {

    private final ApoderadoRepository apoderadoRepository;

    public ApoderadoDeleteService(ApoderadoRepository apoderadoRepository) {
        this.apoderadoRepository = apoderadoRepository;
    }

    public void execute(UUID uuid) {
        apoderadoRepository.delete(uuid);
    }
}
