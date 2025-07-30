package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.dtos.get.TarifarioDTO;
import com.saludsystem.submodules.mantenimiento.service.tarifario.TarifarioByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TarifarioByIdHandler {

    private final TarifarioByIdService tarifarioByIdService;

    public TarifarioByIdHandler(TarifarioByIdService tarifarioByIdService) {
        this.tarifarioByIdService = tarifarioByIdService;
    }

    public TarifarioDTO execute(UUID uuid) {
        return tarifarioByIdService.execute(uuid);
    }
}
