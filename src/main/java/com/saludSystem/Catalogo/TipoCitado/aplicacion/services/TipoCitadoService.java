package com.saludSystem.Catalogo.TipoCitado.aplicacion.services;

import com.saludSystem.Catalogo.TipoCitado.aplicacion.dtos.ActualizarTipoCitadoDTO;
import com.saludSystem.Catalogo.TipoCitado.aplicacion.dtos.CrearTipoCitadoDTO;
import com.saludSystem.Catalogo.TipoCitado.aplicacion.dtos.TipoCitadoDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

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
