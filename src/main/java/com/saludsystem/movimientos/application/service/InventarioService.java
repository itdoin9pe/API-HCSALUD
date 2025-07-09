package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.post.CrearInventarioDTO;
import com.saludsystem.movimientos.application.dto.get.InventarioDTO;
import com.saludsystem.movimientos.application.dto.put.ActualizarInventarioDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface InventarioService {

    ApiResponse saveInventario(CrearInventarioDTO inventarioDTO);

    ApiResponse updateInventario(UUID inventarioId, ActualizarInventarioDTO actualizarInventarioDTO);

    ApiResponse deleteInventario(UUID inventarioId);

    InventarioDTO getInventarioById(UUID inventarioId);

    ListResponse<InventarioDTO> getAllInventario(UUID hospitalId, int page, int rows);

}