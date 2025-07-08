package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.res.VentaRequest;
import com.saludsystem.movimientos.application.dto.res.VentaDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import java.util.List;
import java.util.UUID;

public interface VentaService {

    ApiResponse saveVenta(com.saludsystem.movimientos.application.dto.req.VentaRequest ventaRequest);

    List<VentaDTO> getVentaList();

    VentaRequest getVentaById(UUID ventaId);

    ListResponse<VentaDTO> getAllVenta(UUID hospitalId, int page, int rows);

    ApiResponse deleteVenta(UUID ventaId);

}