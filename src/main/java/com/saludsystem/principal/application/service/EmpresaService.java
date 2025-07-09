package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.get.EmpresaDTO;
import com.saludsystem.principal.application.dto.post.CrearEmpresaDTO;
import com.saludsystem.principal.application.dto.put.ActualizarEmpresaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface EmpresaService extends GenericService<
        EmpresaDTO,
        CrearEmpresaDTO,
        ActualizarEmpresaDTO,
        UUID> {
}