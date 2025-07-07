package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.res.VentaByIdDTO;
import com.saludsystem.movimientos.application.dto.res.VentaDTO;
import com.saludsystem.movimientos.application.dto.req.CrearVentaDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import java.util.List;
import java.util.UUID;

public interface VentaService {

    ApiResponse saveVenta(CrearVentaDTO crearVentaDTO);

    List<VentaDTO> getVentaList();

    VentaByIdDTO getVentaById(UUID ventaId);

    ListResponse<VentaDTO> getAllVenta(UUID hospitalId, int page, int rows);

    ApiResponse deleteVenta(UUID ventaId);

}