package com.saludsystem.submodules.operaciones.command.delete;

import com.saludsystem.submodules.operaciones.service.tipo_material.TipoMaterialDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoMaterialDeleteHandler {

    private final TipoMaterialDeleteService tipoMaterialDeleteService;

    public TipoMaterialDeleteHandler(TipoMaterialDeleteService tipoMaterialDeleteService) {
        this.tipoMaterialDeleteService = tipoMaterialDeleteService;
    }

    public void execute(UUID uuid) {

        tipoMaterialDeleteService.execute(uuid);

    }

}
