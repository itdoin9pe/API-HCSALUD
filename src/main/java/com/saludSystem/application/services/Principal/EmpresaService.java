package com.saludSystem.application.services.Principal;


import com.saludSystem.application.dtos.Principal.PUT.ActualizarEmpresaDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearEmpresaDTO;
import com.saludSystem.application.dtos.Principal.GET.EmpresaDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;

import java.util.List;
import java.util.UUID;

public interface EmpresaService {

    List<EmpresaDTO> getEmpresaList();

    ApiResponse saveEmpresa(CrearEmpresaDTO crearEmpresaDTO);

    EmpresaDTO getEmpresaById(UUID empresaId);

    ApiResponse deleteEmpresa(UUID empresaId);

    ApiResponse updateEmpresa(UUID empresaId, ActualizarEmpresaDTO actualizarEmpresaDTO);

}