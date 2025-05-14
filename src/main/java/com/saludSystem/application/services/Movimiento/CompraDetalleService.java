package com.saludSystem.application.services.Movimiento;

import com.saludSystem.application.dtos.Movimientos.GET.CompraDetalleDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearCompraDetalleDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarCompraDetalleDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CompraDetalleService {

    ApiResponse saveCompraDetalle(CrearCompraDetalleDTO crearCompraDetalleDTO);

    ApiResponse updateCompraDetalle(UUID compraDetalleId, ActualizarCompraDetalleDTO actualizarCompraDetalleDTO);

    CompraDetalleDTO getCompraDetalleById(UUID compraDetalleId);

    ListResponse<CompraDetalleDTO> getAllCompraDetalle(UUID hospitalId, int page, int rows);

    ApiResponse deleteCompraDetalle(UUID compraDetalleId);

}