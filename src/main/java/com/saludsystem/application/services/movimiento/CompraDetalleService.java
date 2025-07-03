package com.saludsystem.application.services.movimiento;

import com.saludsystem.application.dtos.movimientos.get.CompraDetalleDTO;
import com.saludsystem.application.dtos.movimientos.post.CrearCompraDetalleDTO;
import com.saludsystem.application.dtos.movimientos.put.ActualizarCompraDetalleDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CompraDetalleService {

    ApiResponse saveCompraDetalle(CrearCompraDetalleDTO crearCompraDetalleDTO);

    ApiResponse updateCompraDetalle(UUID compraDetalleId, ActualizarCompraDetalleDTO actualizarCompraDetalleDTO);

    CompraDetalleDTO getCompraDetalleById(UUID compraDetalleId);

    ListResponse<CompraDetalleDTO> getAllCompraDetalle(UUID hospitalId, int page, int rows);

    ApiResponse deleteCompraDetalle(UUID compraDetalleId);

}