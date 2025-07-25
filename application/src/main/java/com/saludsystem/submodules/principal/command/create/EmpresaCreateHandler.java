package com.saludsystem.submodules.principal.command.create;

import com.saludsystem.submodules.principal.model.dtos.post.CrearEmpresaDTO;
import com.saludsystem.submodules.principal.service.empresa.EmpresaCreateService;
import org.springframework.stereotype.Component;

@Component
public class EmpresaCreateHandler {

    private final EmpresaCreateService empresaCreateService;

    public EmpresaCreateHandler(EmpresaCreateService empresaCreateService) {
        this.empresaCreateService = empresaCreateService;
    }

    public void execute(CrearEmpresaDTO dto) {
        empresaCreateService.execute(dto);
    }

}
