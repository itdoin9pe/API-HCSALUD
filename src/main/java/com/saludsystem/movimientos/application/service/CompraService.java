package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.res.CompraDTO;
import com.saludsystem.movimientos.application.dto.req.CrearCompraDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CompraService {

    ApiResponse saveCompra(CrearCompraDTO crearCompraDTO);

    ApiResponse deleteCompra(UUID hospitalId);

    ListResponse<CompraDTO> getAllCompra(UUID hospitalId, int page, int rows);

    CompraDTO getCompraById(UUID compraId);

}