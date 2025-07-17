package com.saludsystem.submodules.catalogo.service.alergia;

import com.saludsystem.submodules.catalogo.port.repository.AlergiaRepository;

import java.util.UUID;

public class AlergiaDeleteService {
    private final AlergiaRepository alergiaRepository;

    public AlergiaDeleteService(AlergiaRepository alergiaRepository) {
        this.alergiaRepository = alergiaRepository;
    }

    public void execute(UUID uuid) {
        alergiaRepository.delete(uuid);
    }
}
