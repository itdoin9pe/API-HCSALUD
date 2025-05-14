package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.POST.CrearTipoCitadoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.TipoCitadoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarTipoCitadoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface TipoCitadoService {

    ApiResponse saveTipoCitado(CrearTipoCitadoDTO crearTipoCitadoDTO);

    ApiResponse updateTipoCitado(UUID tipoCitadoId, ActualizarTipoCitadoDTO actualizarTipoCitadoDTO);

    TipoCitadoDTO getTipoCitadoById(UUID tipoCitadoId);

    List<TipoCitadoDTO> getTipoCitadoList();

    ApiResponse deleteTipoCitado(UUID tipocitadoId);

    ListResponse<TipoCitadoDTO> getAllTipoCitado(UUID hospitalId, int page, int rows);

}
