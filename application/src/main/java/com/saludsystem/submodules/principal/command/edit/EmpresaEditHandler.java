package com.saludsystem.submodules.principal.command.edit;

import com.saludsystem.submodules.principal.mapper.EmpresaMapper;
import com.saludsystem.submodules.principal.model.dtos.command.edit.EmpresaEditCommand;
import com.saludsystem.submodules.principal.service.empresa.EmpresaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmpresaEditHandler {

    private final EmpresaEditService empresaEditService;
    private final EmpresaMapper empresaMapper;

    public EmpresaEditHandler(EmpresaEditService empresaEditService, EmpresaMapper empresaMapper) {
        this.empresaEditService = empresaEditService;
        this.empresaMapper = empresaMapper;
    }

    public void execute(UUID uuid, EmpresaEditCommand editCommand) {

        var empresaUpdated = empresaMapper.fromUpdateDto(uuid, editCommand);

        empresaEditService.execute(uuid, empresaUpdated);

    }

}
