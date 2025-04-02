package com.saludSystem.application.services.Principal;


import com.saludSystem.application.dtos.Principal.PUT.ActualizarEstudioDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearEstudioDTO;
import com.saludSystem.application.dtos.Principal.GET.EstudioDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface EstudioService {

    ApiResponse saveEstudio(CrearEstudioDTO crearEstudioDTO);

    EstudioDTO getEstudioById(UUID estudioId);

    ApiResponse deleteEstudio(UUID estudioId);

    ListResponse<EstudioDTO> getAllEstudios(UUID hospitalId, int page, int rows);

    ApiResponse updateEstudio(UUID estudioId, ActualizarEstudioDTO actualizarEstudioDTO);

    List<EstudioDTO> getEstudioList();

}