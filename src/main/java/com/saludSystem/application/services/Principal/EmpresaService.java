package com.saludSystem.application.services.Principal;

import com.saludSystem.application.dtos.Principal.POST.CrearEmpresaDTO;
import com.saludSystem.application.dtos.Principal.PUT.ActualizarEmpresaDTO;
import com.saludSystem.application.dtos.Principal.GET.EmpresaDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface EmpresaService extends GenericService<
        EmpresaDTO,
        UUID,
        CrearEmpresaDTO,
        ActualizarEmpresaDTO> {
}