package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoPagoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoPagoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoPagoDTO;

import java.util.List;
import java.util.UUID;

public interface TipoPagoService {

    ApiResponse saveTipoPago(CrearTipoPagoDTO crearTipoPagoDTO);

    ListResponse<TipoPagoDTO> getAllTipoPago(UUID hospitalId, int page, int rows);

    List<TipoPagoDTO> getListTipoPago();

    TipoPagoDTO getTipoPagoById(UUID tipoPagoId);

    ApiResponse updateTipoPago(UUID tipoPagoId, ActualizarTipoPagoDTO actualizarTipoPagoDTO);

    ApiResponse deleteTipoPago(UUID tipoPagoId);

}