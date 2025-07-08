package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.res.EmpresaResponse;
import com.saludsystem.principal.application.dto.req.EmpresaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface EmpresaService extends GenericService<
        EmpresaRequest,
        EmpresaResponse,
        UUID> {
}