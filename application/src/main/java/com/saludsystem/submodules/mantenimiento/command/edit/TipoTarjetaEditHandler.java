package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.dtos.put.ActualizarTipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.service.tipotarjeta.TipoTarjetaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoTarjetaEditHandler {

    private final TipoTarjetaEditService tipoTarjetaEditService;

    public TipoTarjetaEditHandler(TipoTarjetaEditService tipoTarjetaEditService) {
        this.tipoTarjetaEditService = tipoTarjetaEditService;
    }

    public void execute(UUID uuid, ActualizarTipoTarjetaDTO dto) {
        tipoTarjetaEditService.execute(uuid, dto);
    }
}
