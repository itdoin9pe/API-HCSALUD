package com.saludsystem.submodules.operaciones.command.delete;

import com.saludsystem.submodules.operaciones.service.categoria_material.CategoriaMaterialDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaMaterialDeleteHandler {

    private final CategoriaMaterialDeleteService categoriaMaterialDeleteService;

    public CategoriaMaterialDeleteHandler(CategoriaMaterialDeleteService categoriaMaterialDeleteService) {
        this.categoriaMaterialDeleteService = categoriaMaterialDeleteService;
    }

    public void execute(UUID uuid) {
        categoriaMaterialDeleteService.execute(uuid);
    }

}
