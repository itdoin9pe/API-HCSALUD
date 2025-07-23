package com.saludsystem.submodules.mantenimiento.command.delete;

import com.saludsystem.submodules.mantenimiento.service.tarifario.TarifarioDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TarifarioDeleteHandler {

    private final TarifarioDeleteService tarifarioDeleteService;

    public TarifarioDeleteHandler(TarifarioDeleteService tarifarioDeleteService) {
        this.tarifarioDeleteService = tarifarioDeleteService;
    }

    public void execute(UUID uuid) {
        tarifarioDeleteService.execute(uuid);
    }

}
