package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.res.CompraResponse;
import com.saludsystem.movimientos.application.dto.req.CompraRequest;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CompraService {

    ApiResponse saveCompra(CompraRequest compraRequest);

    ApiResponse deleteCompra(UUID hospitalId);

    ListResponse<CompraResponse> getAllCompra(UUID hospitalId, int page, int rows);

    CompraResponse getCompraById(UUID compraId);

}