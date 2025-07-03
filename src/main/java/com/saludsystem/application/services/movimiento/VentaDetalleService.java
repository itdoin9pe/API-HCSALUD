package com.saludsystem.application.services.movimiento;

import com.saludsystem.application.dtos.movimientos.get.VentaDetalleDTO;
import com.saludsystem.application.dtos.movimientos.post.CrearVentaDetalleDTO;
import com.saludsystem.application.dtos.movimientos.put.ActualizarVentaDetalleDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface VentaDetalleService {

    ApiResponse saveVentaDetalle(CrearVentaDetalleDTO crearVentaDetalleDTO);

    ApiResponse deleteVentaDetalle(UUID ventaDetalleId);

    ApiResponse updateVentaDetalle(UUID ventaDetalleId, ActualizarVentaDetalleDTO actualizarVentaDetalleDTO);

    VentaDetalleDTO getVentaDetalleById(UUID ventaDetalleId);

    ListResponse<VentaDetalleDTO> getAllVentaDetalle(UUID hospitalId, int page, int rows);

}