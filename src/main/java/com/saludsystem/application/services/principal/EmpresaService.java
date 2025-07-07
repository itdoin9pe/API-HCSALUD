package com.saludsystem.application.services.principal;

import com.saludsystem.application.dtos.principal.res.EmpresaDTO;
import com.saludsystem.application.dtos.principal.req.CrearEmpresaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface EmpresaService extends GenericService<
        CrearEmpresaDTO,
        EmpresaDTO,
        UUID> {
}