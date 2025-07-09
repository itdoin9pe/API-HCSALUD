package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.post.CrearVentaDTO;
import com.saludsystem.movimientos.application.dto.get.VentaDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import java.util.List;
import java.util.UUID;

public interface VentaService {

    ApiResponse saveVenta(CrearVentaDTO crearVentaDTO);

    List<VentaDTO> getVentaList();

    VentaDTO getVentaById(UUID ventaId);

    ListResponse<VentaDTO> getAllVenta(UUID hospitalId, int page, int rows);

    ApiResponse deleteVenta(UUID ventaId);

}