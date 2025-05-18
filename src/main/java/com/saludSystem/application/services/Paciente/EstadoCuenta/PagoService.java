package com.saludSystem.application.services.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.PagoDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearPagoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarPagoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface PagoService {

    ApiResponse savePago(CrearPagoDTO crearPagoDTO);

    ListResponse<PagoDTO> getAllPago(UUID hospitalId, int page, int rows);

    ApiResponse updatePago(UUID pec_pagoId, ActualizarPagoDTO actualizarPagoDTO);

    PagoDTO getPagoById(UUID pec_pagoId);

    ApiResponse deletePago(UUID pec_pagoId);

}