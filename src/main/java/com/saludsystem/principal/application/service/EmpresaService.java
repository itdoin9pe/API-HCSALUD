package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.res.EmpresaDTO;
import com.saludsystem.principal.application.dto.req.CrearEmpresaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface EmpresaService extends GenericService<
        CrearEmpresaDTO,
        EmpresaDTO,
        UUID> {
}