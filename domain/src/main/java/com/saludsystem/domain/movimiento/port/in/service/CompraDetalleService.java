package com.saludsystem.domain.movimiento.port.in.service;

import com.saludsystem.movimientos.application.dto.post.CrearCompraDetalleDTO;
import com.saludsystem.movimientos.application.dto.get.CompraDetalleDTO;
import com.saludsystem.movimientos.application.dto.put.ActualizarCompraDetalleDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CompraDetalleService {

    ApiResponse saveCompraDetalle(CompraDetalleDTO compraDetalleDTO);

    ApiResponse updateCompraDetalle(UUID compraDetalleId, ActualizarCompraDetalleDTO actualizarCompraDetalleDTO);

    CrearCompraDetalleDTO getCompraDetalleById(UUID compraDetalleId);

    ListResponse<CrearCompraDetalleDTO> getAllCompraDetalle(UUID hospitalId, int page, int rows);

    ApiResponse deleteCompraDetalle(UUID compraDetalleId);

}