package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.res.PaisResponse;
import com.saludsystem.principal.application.dto.req.PaisRequest;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PaisService {

    ApiResponse savePais(PaisRequest paisRequest);

    ListResponse<PaisResponse> getAllPais(UUID hospitalId, int page, int rows);

    List<PaisResponse> getPaisList();

}