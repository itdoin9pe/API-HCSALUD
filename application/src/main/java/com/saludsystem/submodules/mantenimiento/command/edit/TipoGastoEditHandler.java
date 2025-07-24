package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarTipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.service.tipogasto.TipoGastoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoGastoEditHandler {

    private final TipoGastoEditService tipoGastoEditService;

    public TipoGastoEditHandler(TipoGastoEditService tipoGastoEditService) {
        this.tipoGastoEditService = tipoGastoEditService;
    }

    public void execute(UUID uuid, ActualizarTipoGastoDTO dto) {
        tipoGastoEditService.execute(uuid, dto);
    }

}
