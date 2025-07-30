package com.saludsystem.submodules.operaciones.command.create;

import com.saludsystem.submodules.operaciones.dtos.command.CrearCategotiaMatDTO;
import com.saludsystem.submodules.operaciones.service.categoria_material.CategoriaMaterialCreateService;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMaterialCreateHandler {

    private final CategoriaMaterialCreateService categoriaMaterialCreateService;

    public CategoriaMaterialCreateHandler(CategoriaMaterialCreateService categoriaMaterialCreateService) {
        this.categoriaMaterialCreateService = categoriaMaterialCreateService;
    }

    public void execute(CrearCategotiaMatDTO dto) {
        categoriaMaterialCreateService.execute(dto);
    }

}
