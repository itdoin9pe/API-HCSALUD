package com.saludSystem.aplicacion.services.modules.Catalogo.TipoCitado;

import com.saludSystem.aplicacion.dtos.Catalogo.TipoCitado.ActualizarTipoCitadoDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.TipoCitado.CrearTipoCitadoDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.TipoCitado.TipoCitadoDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.ListResponse;

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