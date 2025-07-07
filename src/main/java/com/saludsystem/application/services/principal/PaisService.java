package com.saludsystem.application.services.principal;

import com.saludsystem.application.dtos.principal.res.PaisDTO;
import com.saludsystem.application.dtos.principal.req.CrearPaisDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PaisService {

    ApiResponse savePais(CrearPaisDTO crearPaisDTO);

    ListResponse<PaisDTO> getAllPais(UUID hospitalId, int page, int rows);

    List<PaisDTO> getPaisList();

}