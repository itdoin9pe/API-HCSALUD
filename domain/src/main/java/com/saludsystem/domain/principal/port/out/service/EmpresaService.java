package com.saludsystem.domain.principal.port.out.service;

import com.saludsystem.application.dto.get.EmpresaDTO;
import com.saludsystem.application.dto.post.CrearEmpresaDTO;
import com.saludsystem.application.dto.put.ActualizarEmpresaDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface EmpresaService extends GenericService<
        EmpresaDTO,
        CrearEmpresaDTO,
        ActualizarEmpresaDTO,
        UUID> {
}