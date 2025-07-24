package com.saludsystem.submodules.mantenimiento.service.tipotarjeta;

import com.saludsystem.submodules.mantenimiento.port.repository.TipoTarjetaRepository;

import java.util.UUID;

public class TipoTarjetaDeleteService {

    private final TipoTarjetaRepository tipoTarjetaRepository;

    public TipoTarjetaDeleteService(TipoTarjetaRepository tipoTarjetaRepository) {
        this.tipoTarjetaRepository = tipoTarjetaRepository;
    }

    public void execute(UUID uuid) {
        tipoTarjetaRepository.delete(uuid);
    }

}
