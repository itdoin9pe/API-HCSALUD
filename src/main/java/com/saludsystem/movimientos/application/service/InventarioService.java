package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.res.InventarioResponse;
import com.saludsystem.movimientos.application.dto.req.InventarioRequest;
import com.saludsystem.movimientos.application.dto.ActualizarInventarioDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface InventarioService {

    ApiResponse saveInventario(InventarioRequest inventarioRequest);

    ApiResponse updateInventario(UUID inventarioId, ActualizarInventarioDTO actualizarInventarioDTO);

    ApiResponse deleteInventario(UUID inventarioId);

    InventarioResponse getInventarioById(UUID inventarioId);

    ListResponse<InventarioResponse> getAllInventario(UUID hospitalId, int page, int rows);

}