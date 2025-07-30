package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.dtos.get.TipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.service.tipotarjeta.TipoTarjetaByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoTarjetaByIdHandler {

    private final TipoTarjetaByIdService tipoTarjetaByIdService;

    public TipoTarjetaByIdHandler(TipoTarjetaByIdService tipoTarjetaByIdService) {
        this.tipoTarjetaByIdService = tipoTarjetaByIdService;
    }

    public TipoTarjetaDTO execute(UUID uuid) {
        return tipoTarjetaByIdService.execute(uuid);
    }
}
