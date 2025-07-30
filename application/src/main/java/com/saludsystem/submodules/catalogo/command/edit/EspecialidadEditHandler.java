package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarEspecialidadDTO;
import com.saludsystem.submodules.catalogo.service.especialidad.EspecialidadEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadEditHandler {

    private final EspecialidadEditService especialidadEditService;

    public EspecialidadEditHandler(EspecialidadEditService especialidadEditService) {
        this.especialidadEditService = especialidadEditService;
    }

    public void execute(UUID uuid, ActualizarEspecialidadDTO dto) {
        especialidadEditService.execute(uuid, dto);
    }

}