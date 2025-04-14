package com.saludSystem.application.services.Movimiento;

import com.saludSystem.application.dtos.Movimientos.GET.VentaByIdDTO;
import com.saludSystem.application.dtos.Movimientos.GET.VentaDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearVentaDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import java.util.List;
import java.util.UUID;

public interface VentaService {

    ApiResponse saveVenta(CrearVentaDTO crearVentaDTO);

    List<VentaDTO> getVentaList();

    VentaByIdDTO getVentaById(UUID ventaId);

    ListResponse<VentaDTO> getAllVenta(UUID hospitalId, int page, int rows);

    ApiResponse deleteVenta(UUID ventaId);

}