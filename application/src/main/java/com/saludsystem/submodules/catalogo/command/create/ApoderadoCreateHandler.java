package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearApoderadoDTO;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoCreateService;
import org.springframework.stereotype.Component;

@Component
public class ApoderadoCreateHandler {

    private final ApoderadoCreateService apoderadoCreateService;

    public ApoderadoCreateHandler(ApoderadoCreateService apoderadoCreateService) {
        this.apoderadoCreateService = apoderadoCreateService;
    }

    public void execute(CrearApoderadoDTO dto) {
        apoderadoCreateService.execute(dto);
    }
}