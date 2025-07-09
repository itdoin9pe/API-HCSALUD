package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.post.CrearCompraDTO;
import com.saludsystem.movimientos.application.dto.get.CompraDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CompraService {

    ApiResponse saveCompra(CompraDTO compraDTO);

    ApiResponse deleteCompra(UUID hospitalId);

    ListResponse<CrearCompraDTO> getAllCompra(UUID hospitalId, int page, int rows);

    CrearCompraDTO getCompraById(UUID compraId);

}