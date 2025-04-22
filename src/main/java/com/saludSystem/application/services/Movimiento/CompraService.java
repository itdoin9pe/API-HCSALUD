package com.saludSystem.application.services.Movimiento;

import com.saludSystem.application.dtos.Movimientos.GET.CompraDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearCompraDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarCompraDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CompraService {

    ApiResponse saveCompra(CrearCompraDTO crearCompraDTO);

    ApiResponse deleteCompra(UUID compraId, ActualizarCompraDTO actualizarCompraDTO);

    ListResponse<CompraDTO> getAllCompra(UUID compraId, int page, int rows);

}