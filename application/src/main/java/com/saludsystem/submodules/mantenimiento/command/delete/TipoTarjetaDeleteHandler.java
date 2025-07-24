package com.saludsystem.submodules.mantenimiento.command.delete;

import com.saludsystem.submodules.mantenimiento.service.tipotarjeta.TipoTarjetaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoTarjetaDeleteHandler {

    private final TipoTarjetaDeleteService tipoTarjetaDeleteService;

    public TipoTarjetaDeleteHandler(TipoTarjetaDeleteService tipoTarjetaDeleteService) {
        this.tipoTarjetaDeleteService = tipoTarjetaDeleteService;
    }

    public void execute(UUID uuid) {
        tipoTarjetaDeleteService.execute(uuid);
    }
}
