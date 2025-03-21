package com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.dtos.ActualizarTipoTarjetaDTO;
import com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.dtos.CrearTipoTarjetaDTO;
import com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.dtos.TipoTarjetaDTO;

import java.util.List;
import java.util.UUID;

public interface TipoTarjetaService {

    ApiResponse saveTipoTarjeta(CrearTipoTarjetaDTO crearTipoTarjetaDTO);

    List<TipoTarjetaDTO> getTipoTarjetaList();

    ListResponse<TipoTarjetaDTO> getAllTipoTarjeta(UUID hospitalId, int page, int rows);

    TipoTarjetaDTO getTipoTarjetaById(UUID tipoTarjetaId);

    ApiResponse updateTipoTarjeta(UUID tipoTarjetaId, ActualizarTipoTarjetaDTO actualizarTipoTarjetaDTO);

    ApiResponse deleteTipoTarjeta(UUID tipoTarjetaId);

}
