package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadDeleteHandler {
    private final EspecialidadRepository especialidadRepository;

    public EspecialidadDeleteHandler(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public void execute(UUID uuid){
        especialidadRepository.delete(uuid);
    }
}