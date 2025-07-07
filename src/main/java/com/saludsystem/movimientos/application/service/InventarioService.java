package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.res.InventarioDTO;
import com.saludsystem.movimientos.application.dto.req.CrearInventarioDTO;
import com.saludsystem.movimientos.application.dto.ActualizarInventarioDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface InventarioService {

    ApiResponse saveInventario(CrearInventarioDTO crearInventarioDTO);

    ApiResponse updateInventario(UUID inventarioId, ActualizarInventarioDTO actualizarInventarioDTO);

    ApiResponse deleteInventario(UUID inventarioId);

    InventarioDTO getInventarioById(UUID inventarioId);

    ListResponse<InventarioDTO> getAllInventario(UUID hospitalId, int page, int rows);

}