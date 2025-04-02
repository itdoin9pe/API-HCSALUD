package com.saludSystem.application.services.Operaciones;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarUnidadDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearUnidadDTO;
import com.saludSystem.application.dtos.Operaciones.GET.UnidadDTO;

import java.util.List;
import java.util.UUID;

public interface UnidadService {

    ApiResponse saveUnidad(CrearUnidadDTO crearUnidadDTO);

    List<UnidadDTO> getUnidadList();

    UnidadDTO getUnidadById(UUID unidadId);

    ListResponse<UnidadDTO> getAllUnidad(UUID hospitalId, int page, int rows);

    ApiResponse updateUnidad(UUID unidadId, ActualizarUnidadDTO actualizarUnidadDTO);

    ApiResponse deleteUnidad(UUID unidadId);

}