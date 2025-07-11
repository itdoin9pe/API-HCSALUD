package com.saludsystem.domain.principal.port.out.service;

import com.saludsystem.application.dto.get.PaisDTO;
import com.saludsystem.application.dto.post.CrearPaisDTO;
import com.shared.infrastructure.adapters.in.response.ApiResponse;
import com.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PaisService {

    ApiResponse savePais(CrearPaisDTO crearPaisDTO);

    ListResponse<PaisDTO> getAllPais(UUID hospitalId, int page, int rows);

    List<PaisDTO> getPaisList();

}