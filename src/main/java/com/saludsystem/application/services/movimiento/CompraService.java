package com.saludsystem.application.services.movimiento;

import com.saludsystem.application.dtos.movimientos.get.CompraDTO;
import com.saludsystem.application.dtos.movimientos.post.CrearCompraDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CompraService {

    ApiResponse saveCompra(CrearCompraDTO crearCompraDTO);

    ApiResponse deleteCompra(UUID hospitalId);

    ListResponse<CompraDTO> getAllCompra(UUID hospitalId, int page, int rows);

    CompraDTO getCompraById(UUID compraId);

}