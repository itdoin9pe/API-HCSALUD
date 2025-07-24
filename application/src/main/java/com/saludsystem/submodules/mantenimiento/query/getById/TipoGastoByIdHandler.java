package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.TipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.service.tipogasto.TipoGastoByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoGastoByIdHandler {

    private final TipoGastoByIdService tipoGastoByIdService;

    public TipoGastoByIdHandler(TipoGastoByIdService tipoGastoByIdService) {
        this.tipoGastoByIdService = tipoGastoByIdService;
    }

    public TipoGastoDTO execute(UUID uuid) {
        return tipoGastoByIdService.execute(uuid);
    }

}
