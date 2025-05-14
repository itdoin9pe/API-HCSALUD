package com.saludSystem.application.services.Principal;


import com.saludSystem.application.dtos.Principal.POST.CrearPaisDTO;
import com.saludSystem.application.dtos.Principal.GET.PaisDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PaisService {

    ApiResponse savePais(CrearPaisDTO crearPaisDTO);

    ListResponse<PaisDTO> getAllPais(UUID hospitalId, int page, int rows);

    List<PaisDTO> getPaisList();

}