package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.get.VentaDetalleDTO;
import com.saludsystem.movimientos.application.dto.post.CrearVentaDetalleDTO;
import com.saludsystem.movimientos.application.dto.put.ActualizarVentaDetalleDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface VentaDetalleService {

    ApiResponse saveVentaDetalle(VentaDetalleDTO crearVentaDetalleDTO);

    ApiResponse deleteVentaDetalle(UUID ventaDetalleId);

    ApiResponse updateVentaDetalle(UUID ventaDetalleId, ActualizarVentaDetalleDTO actualizarVentaDetalleDTO);

    CrearVentaDetalleDTO getVentaDetalleById(UUID ventaDetalleId);

    ListResponse<CrearVentaDetalleDTO> getAllVentaDetalle(UUID hospitalId, int page, int rows);

}