package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.res.CompraDetalleDTO;
import com.saludsystem.movimientos.application.dto.req.CrearCompraDetalleDTO;
import com.saludsystem.movimientos.application.dto.ActualizarCompraDetalleDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CompraDetalleService {

    ApiResponse saveCompraDetalle(CrearCompraDetalleDTO crearCompraDetalleDTO);

    ApiResponse updateCompraDetalle(UUID compraDetalleId, ActualizarCompraDetalleDTO actualizarCompraDetalleDTO);

    CompraDetalleDTO getCompraDetalleById(UUID compraDetalleId);

    ListResponse<CompraDetalleDTO> getAllCompraDetalle(UUID hospitalId, int page, int rows);

    ApiResponse deleteCompraDetalle(UUID compraDetalleId);

}