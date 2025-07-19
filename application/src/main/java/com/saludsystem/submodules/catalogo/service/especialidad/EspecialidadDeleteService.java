package com.saludsystem.submodules.catalogo.service.especialidad;

import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;

import java.util.UUID;

public class EspecialidadDeleteService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadDeleteService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public void execute(UUID uuid) {
        especialidadRepository.delete(uuid);
    }
}
