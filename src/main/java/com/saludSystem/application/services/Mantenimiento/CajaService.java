package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarCajaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.CajaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearCajaDTO;

import java.util.List;
import java.util.UUID;

public interface CajaService {

    ApiResponse saveCaja(CrearCajaDTO crearCajaDTO);

    List<CajaDTO> getCajaList();

    ListResponse<CajaDTO> getAllCaja(UUID hospitalId, int page, int rows);

    CajaDTO getCajaById(UUID cajaId);

    ApiResponse updateCaja(UUID cajaId, ActualizarCajaDTO actualizarCajaDTO);

    ApiResponse deleteCaja(UUID cajaId);

}