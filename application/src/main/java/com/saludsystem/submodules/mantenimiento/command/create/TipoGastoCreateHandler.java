package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearTipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.service.tipogasto.TipoGastoCreateService;
import org.springframework.stereotype.Component;

@Component
public class TipoGastoCreateHandler {

    private final TipoGastoCreateService tipoGastoCreateService;

    public TipoGastoCreateHandler(TipoGastoCreateService tipoGastoCreateService) {
        this.tipoGastoCreateService = tipoGastoCreateService;
    }

    public void execute(CrearTipoGastoDTO dto) {
        tipoGastoCreateService.execute(dto);
    }

}
