package com.saludsystem.application.services.movimiento;

import com.saludsystem.application.dtos.movimientos.get.InventarioDTO;
import com.saludsystem.application.dtos.movimientos.post.CrearInventarioDTO;
import com.saludsystem.application.dtos.movimientos.put.ActualizarInventarioDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface InventarioService {

    ApiResponse saveInventario(CrearInventarioDTO crearInventarioDTO);

    ApiResponse updateInventario(UUID inventarioId, ActualizarInventarioDTO actualizarInventarioDTO);

    ApiResponse deleteInventario(UUID inventarioId);

    InventarioDTO getInventarioById(UUID inventarioId);

    ListResponse<InventarioDTO> getAllInventario(UUID hospitalId, int page, int rows);

}