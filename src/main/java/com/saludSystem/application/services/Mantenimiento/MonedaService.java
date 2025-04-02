package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarMonedaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearMonedaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.MonedaDTO;

import java.util.List;
import java.util.UUID;

public interface MonedaService {

    ApiResponse saveMoneda(CrearMonedaDTO crearMonedaDTO);

    ListResponse<MonedaDTO> getAllMoneda(UUID hospitalId, int page, int rows);

    List<MonedaDTO> getMonedaList();

    MonedaDTO getMonedaById(UUID monedaId);

    ApiResponse updateMoneda(UUID monedaId, ActualizarMonedaDTO actualizarMonedaDTO);

    ApiResponse deleteMoneda(UUID monedaId);

}