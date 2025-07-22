package com.saludsystem.submodules.mantenimiento.service.caja;

import com.saludsystem.submodules.mantenimiento.port.service.CajaRepository;

import java.util.UUID;

public class CajaDeleteService {

    private final CajaRepository cajaRepository;

    public CajaDeleteService(CajaRepository cajaRepository) {
        this.cajaRepository = cajaRepository;
    }

    public void execute(UUID uuid) {
        cajaRepository.delete(uuid);
    }
}
