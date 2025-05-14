package com.saludSystem.application.services.Movimiento;

import com.saludSystem.application.dtos.Movimientos.GET.InventarioDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearInventarioDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarInventarioDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface InventarioService {

    ApiResponse saveInventario(CrearInventarioDTO crearInventarioDTO);

    ApiResponse updateInventario(UUID inventarioId, ActualizarInventarioDTO actualizarInventarioDTO);

    ApiResponse deleteInventario(UUID inventarioId);

    InventarioDTO getInventarioById(UUID inventarioId);

    ListResponse<InventarioDTO> getAllInventario(UUID hospitalId, int page, int rows);

}