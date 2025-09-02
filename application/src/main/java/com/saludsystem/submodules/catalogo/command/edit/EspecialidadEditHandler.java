package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.EspecialidadEditCommand;
import com.saludsystem.submodules.catalogo.service.especialidad.EspecialidadEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadEditHandler {

    private final EspecialidadEditService especialidadEditService;
    private final EspecialidadMapper especialidadMapper;

    public EspecialidadEditHandler(EspecialidadEditService especialidadEditService, EspecialidadMapper especialidadMapper) {
        this.especialidadEditService = especialidadEditService;
        this.especialidadMapper = especialidadMapper;
    }

    public void execute(UUID uuid, EspecialidadEditCommand editCommand) {

        var especialidadUpdate = especialidadMapper.fromUpdateDto(uuid, editCommand);

        especialidadEditService.execute(uuid, especialidadUpdate);

    }

}