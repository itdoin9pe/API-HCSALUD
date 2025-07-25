package com.saludsystem.submodules.principal.query.getById;

import com.saludsystem.submodules.principal.model.dtos.get.EmpresaDTO;
import com.saludsystem.submodules.principal.service.empresa.EmpresaByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmpresaByIdHandler {

    private final EmpresaByIdService empresaByIdService;

    public EmpresaByIdHandler(EmpresaByIdService empresaByIdService) {
        this.empresaByIdService = empresaByIdService;
    }

    public EmpresaDTO execute(UUID uuid) {
        return empresaByIdService.execute(uuid);
    }
}
