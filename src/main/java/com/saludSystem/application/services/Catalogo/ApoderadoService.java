package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarApoderadoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.ApoderadoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearApoderadoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface ApoderadoService {

    ApiResponse saveApoderado(CrearApoderadoDTO crearApoderadoDTO);

    ApiResponse updateApoderado(UUID apoderadoId, ActualizarApoderadoDTO actualizarApoderadoDTO);

    ListResponse<ApoderadoDTO> getAllApoderado(UUID hospitalId, int page, int rows);

    ApoderadoDTO getApoderadoById(UUID apoderadoId);

    ApiResponse deleteApoderado(UUID apoderadoId);

}