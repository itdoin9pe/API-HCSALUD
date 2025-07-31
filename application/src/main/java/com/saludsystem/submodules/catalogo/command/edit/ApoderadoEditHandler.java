package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ApoderadoEditCommand;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApoderadoEditHandler {

    private final ApoderadoEditService apoderadoEditService;
    private final ApoderadoMapper apoderadoMapper;

    public ApoderadoEditHandler(ApoderadoEditService apoderadoEditService, ApoderadoMapper apoderadoMapper) {
        this.apoderadoEditService = apoderadoEditService;
        this.apoderadoMapper = apoderadoMapper;
    }

    public void execute(UUID uuid, ApoderadoEditCommand editCommand) {

        var apoderado = apoderadoMapper.fromUpdateDto(uuid, editCommand);

        apoderadoEditService.execute(uuid, apoderado);

    }
}