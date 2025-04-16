package com.saludSystem.application.services.Movimiento;

import com.saludSystem.application.dtos.Movimientos.GET.VentaDetalleDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearVentaDetalleDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarVentaDetalleDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface VentaDetalleService {

    ApiResponse saveVentaDetalle(CrearVentaDetalleDTO crearVentaDetalleDTO);

    ApiResponse deleteVentaDetalle(UUID ventaDetalleId);

    ApiResponse updateVentaDetalle(UUID ventaDetalleId, ActualizarVentaDetalleDTO actualizarVentaDetalleDTO);

    VentaDetalleDTO getVentaDetalleById(UUID ventaDetalleId);

    ListResponse<VentaDetalleDTO> getAllVentaDetalle(UUID hospitalId, int page, int rows);

}