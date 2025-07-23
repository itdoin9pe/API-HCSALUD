package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearTarifarioDTO;
import com.saludsystem.submodules.mantenimiento.service.tarifario.TarifarioCreateService;
import org.springframework.stereotype.Component;

@Component
public class TarifarioCreateHandler {

    private final TarifarioCreateService tarifarioCreateService;

    public TarifarioCreateHandler(TarifarioCreateService tarifarioCreateService) {
        this.tarifarioCreateService = tarifarioCreateService;
    }

    public void execute(CrearTarifarioDTO dto) {
        tarifarioCreateService.execute(dto);
    }

}
