package com.saludsystem.application.services.movimiento;

import com.saludsystem.application.dtos.movimientos.get.VentaByIdDTO;
import com.saludsystem.application.dtos.movimientos.get.VentaDTO;
import com.saludsystem.application.dtos.movimientos.post.CrearVentaDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import java.util.List;
import java.util.UUID;

public interface VentaService {

    ApiResponse saveVenta(CrearVentaDTO crearVentaDTO);

    List<VentaDTO> getVentaList();

    VentaByIdDTO getVentaById(UUID ventaId);

    ListResponse<VentaDTO> getAllVenta(UUID hospitalId, int page, int rows);

    ApiResponse deleteVenta(UUID ventaId);

}