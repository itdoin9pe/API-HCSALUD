package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarCuentaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearCuentaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.CuentaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CuentaService {

    ApiResponse saveCuenta(CrearCuentaDTO crearCuentaDTO);

    List<CuentaDTO> getCuentaList();

    ListResponse<CuentaDTO> getAllCuenta(UUID hospitalId, int page, int rows);

    ApiResponse updateCuenta(UUID cuentaPagarId, ActualizarCuentaDTO actualizarCuentaDTO);

    CuentaDTO getCuentaById(UUID cuentaPagarId);

    ApiResponse deleteCuenta(UUID cuentaPagarId);

}