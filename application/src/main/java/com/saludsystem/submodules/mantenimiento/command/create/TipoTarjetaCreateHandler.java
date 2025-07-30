package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.dtos.post.CrearTipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.service.tipotarjeta.TipoTarjetaCreateService;
import org.springframework.stereotype.Component;

@Component
public class TipoTarjetaCreateHandler {

    private final TipoTarjetaCreateService tipoTarjetaCreateService;

    public TipoTarjetaCreateHandler(TipoTarjetaCreateService tipoTarjetaCreateService) {
        this.tipoTarjetaCreateService = tipoTarjetaCreateService;
    }

    public void execute(CrearTipoTarjetaDTO dto) {
        tipoTarjetaCreateService.execute(dto);
    }
}
