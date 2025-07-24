package com.saludsystem.submodules.mantenimiento.service.tipogasto;

import com.saludsystem.submodules.mantenimiento.port.repository.TipoGastoRepository;

import java.util.UUID;

public class TipoGastoDeleteService {

    private final TipoGastoRepository tipoGastoRepository;

    public TipoGastoDeleteService(TipoGastoRepository tipoGastoRepository) {
        this.tipoGastoRepository = tipoGastoRepository;
    }

    public void execute(UUID uuid) {
        tipoGastoRepository.delete(uuid);
    }

}
