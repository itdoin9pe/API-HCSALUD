package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.res.VentaDetalleRequest;
import com.saludsystem.movimientos.application.dto.ActualizarVentaDetalleDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface VentaDetalleService {

    ApiResponse saveVentaDetalle(com.saludsystem.movimientos.application.dto.req.VentaDetalleRequest crearVentaDetalleRequest);

    ApiResponse deleteVentaDetalle(UUID ventaDetalleId);

    ApiResponse updateVentaDetalle(UUID ventaDetalleId, ActualizarVentaDetalleDTO actualizarVentaDetalleDTO);

    VentaDetalleRequest getVentaDetalleById(UUID ventaDetalleId);

    ListResponse<VentaDetalleRequest> getAllVentaDetalle(UUID hospitalId, int page, int rows);

}