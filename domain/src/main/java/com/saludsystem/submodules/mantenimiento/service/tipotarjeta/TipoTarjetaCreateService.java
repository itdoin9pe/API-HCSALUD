package com.saludsystem.submodules.mantenimiento.service.tipotarjeta;

import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoTarjetaRepository;

public class TipoTarjetaCreateService {

    private final TipoTarjetaRepository tipoTarjetaRepository;

    public TipoTarjetaCreateService(TipoTarjetaRepository tipoTarjetaRepository) {
        this.tipoTarjetaRepository = tipoTarjetaRepository;
    }

    public TipoTarjeta execute(TipoTarjeta tipoTarjeta) {

        return tipoTarjetaRepository.save(tipoTarjeta);

    }

}
