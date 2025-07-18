package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarApoderadoDTO;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApoderadoEditHandler {

    private final ApoderadoEditService apoderadoEditService;

    public ApoderadoEditHandler(ApoderadoEditService apoderadoEditService) {
        this.apoderadoEditService = apoderadoEditService;
    }

    public void execute(UUID uuid, ActualizarApoderadoDTO dto) {
        apoderadoEditService.execute(uuid, dto);
    }
}