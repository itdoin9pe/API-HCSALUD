package com.saludSystem.Mantenimiento.Cuenta.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.Cuenta.aplicacion.dtos.ActualizarCuentaDTO;
import com.saludSystem.Mantenimiento.Cuenta.aplicacion.dtos.CrearCuentaDTO;
import com.saludSystem.Mantenimiento.Cuenta.aplicacion.dtos.CuentaDTO;
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
