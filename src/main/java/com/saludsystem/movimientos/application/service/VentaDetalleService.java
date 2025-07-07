package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.res.VentaDetalleDTO;
import com.saludsystem.movimientos.application.dto.req.CrearVentaDetalleDTO;
import com.saludsystem.movimientos.application.dto.ActualizarVentaDetalleDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface VentaDetalleService {

    ApiResponse saveVentaDetalle(CrearVentaDetalleDTO crearVentaDetalleDTO);

    ApiResponse deleteVentaDetalle(UUID ventaDetalleId);

    ApiResponse updateVentaDetalle(UUID ventaDetalleId, ActualizarVentaDetalleDTO actualizarVentaDetalleDTO);

    VentaDetalleDTO getVentaDetalleById(UUID ventaDetalleId);

    ListResponse<VentaDetalleDTO> getAllVentaDetalle(UUID hospitalId, int page, int rows);

}