package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarTarifarioDTO;
import com.saludsystem.submodules.mantenimiento.service.tarifario.TarifarioEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TarifarioEditHandler {

    private final TarifarioEditService tarifarioEditService;

    public TarifarioEditHandler(TarifarioEditService tarifarioEditService) {
        this.tarifarioEditService = tarifarioEditService;
    }

    public void execute(UUID uuid, ActualizarTarifarioDTO dto) {
        tarifarioEditService.execute(uuid, dto);
    }

}
