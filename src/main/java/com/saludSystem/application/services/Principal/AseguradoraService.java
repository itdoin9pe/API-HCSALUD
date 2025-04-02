package com.saludSystem.application.services.Principal;

import com.saludSystem.application.dtos.Principal.PUT.ActualizarAseguradoraDTO;
import com.saludSystem.application.dtos.Principal.GET.AseguradoraDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearAseguradoraDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface AseguradoraService {

    ApiResponse saveAseguradora(CrearAseguradoraDTO crearAseguradoraDTO);

    List<AseguradoraDTO> getAseguradoraList();

    ListResponse<AseguradoraDTO> getAllAseguradoras(UUID hospitalId, int page, int rows);

    AseguradoraDTO getAseguradoraById(UUID aseguradoraId);

    ApiResponse updateAseguradora(UUID aseguradoraId, ActualizarAseguradoraDTO actualizarAseguradoraDTO);

    ApiResponse deleteAseguradora(UUID aseguradoraId);

}