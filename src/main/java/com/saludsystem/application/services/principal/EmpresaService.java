package com.saludsystem.application.services.principal;

import com.saludsystem.application.dtos.principal.get.EmpresaDTO;
import com.saludsystem.application.dtos.principal.post.CrearEmpresaDTO;
import com.saludsystem.application.dtos.principal.put.ActualizarEmpresaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface EmpresaService extends GenericService<
        EmpresaDTO,
        UUID,
        CrearEmpresaDTO,
        ActualizarEmpresaDTO> {
}