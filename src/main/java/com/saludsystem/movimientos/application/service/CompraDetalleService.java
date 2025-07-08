package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.res.CompraDetalleResponse;
import com.saludsystem.movimientos.application.dto.req.CompraDetalleRequest;
import com.saludsystem.movimientos.application.dto.ActualizarCompraDetalleDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CompraDetalleService {

    ApiResponse saveCompraDetalle(CompraDetalleRequest compraDetalleRequest);

    ApiResponse updateCompraDetalle(UUID compraDetalleId, ActualizarCompraDetalleDTO actualizarCompraDetalleDTO);

    CompraDetalleResponse getCompraDetalleById(UUID compraDetalleId);

    ListResponse<CompraDetalleResponse> getAllCompraDetalle(UUID hospitalId, int page, int rows);

    ApiResponse deleteCompraDetalle(UUID compraDetalleId);

}