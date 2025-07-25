package com.saludsystem.submodules.principal.command.edit;

import com.saludsystem.submodules.principal.model.dtos.put.ActualizarEmpresaDTO;
import com.saludsystem.submodules.principal.service.empresa.EmpresaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmpresaEditHandler {

    private final EmpresaEditService empresaEditService;

    public EmpresaEditHandler(EmpresaEditService empresaEditService) {
        this.empresaEditService = empresaEditService;
    }

    public void execute(UUID uuid, ActualizarEmpresaDTO dto) {
        empresaEditService.execute(uuid, dto);
    }

}
