package com.saludSystem.application.services.Movimiento;

import com.saludSystem.application.dtos.Movimientos.GET.CompraDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearCompraDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CompraService {

    ApiResponse saveCompra(CrearCompraDTO crearCompraDTO);

    ApiResponse deleteCompra(UUID hospitalId);

    ListResponse<CompraDTO> getAllCompra(UUID hospitalId, int page, int rows);

    CompraDTO getCompraById(UUID compraId);

}