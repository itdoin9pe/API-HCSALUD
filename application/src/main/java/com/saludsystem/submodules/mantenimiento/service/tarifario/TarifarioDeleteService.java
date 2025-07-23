package com.saludsystem.submodules.mantenimiento.service.tarifario;

import com.saludsystem.submodules.mantenimiento.port.repository.TarifarioRepository;

import java.util.UUID;

public class TarifarioDeleteService {

    private final TarifarioRepository tarifarioRepository;

    public TarifarioDeleteService(TarifarioRepository tarifarioRepository) {
        this.tarifarioRepository = tarifarioRepository;
    }

    public void execute(UUID uuid) {
        tarifarioRepository.delete(uuid);
    }
}
