package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.res.PaisDTO;
import com.saludsystem.principal.application.dto.req.CrearPaisDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PaisService {

    ApiResponse savePais(CrearPaisDTO crearPaisDTO);

    ListResponse<PaisDTO> getAllPais(UUID hospitalId, int page, int rows);

    List<PaisDTO> getPaisList();

}