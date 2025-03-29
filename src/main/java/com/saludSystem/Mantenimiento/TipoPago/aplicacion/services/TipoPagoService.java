package com.saludSystem.Mantenimiento.TipoPago.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.TipoPago.aplicacion.dtos.ActualizarTipoPagoDTO;
import com.saludSystem.Mantenimiento.TipoPago.aplicacion.dtos.CrearTipoPagoDTO;
import com.saludSystem.Mantenimiento.TipoPago.aplicacion.dtos.TipoPagoDTO;

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