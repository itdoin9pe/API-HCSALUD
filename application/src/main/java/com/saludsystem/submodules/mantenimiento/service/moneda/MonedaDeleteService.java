package com.saludsystem.submodules.mantenimiento.service.moneda;

import com.saludsystem.submodules.mantenimiento.port.repository.MonedaRepository;

import java.util.UUID;

public class MonedaDeleteService {

    private final MonedaRepository monedaRepository;

    public MonedaDeleteService(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    public void execute(UUID uuid) {
        monedaRepository.delete(uuid);
    }
}
