package com.saludSystem.Mantenimiento.TipoGasto.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.TipoGasto.aplicacion.dtos.ActualizarTipoGastoDTO;
import com.saludSystem.Mantenimiento.TipoGasto.aplicacion.dtos.CrearTipoGastoDTO;
import com.saludSystem.Mantenimiento.TipoGasto.aplicacion.dtos.TipoGastoDTO;

import java.util.List;
import java.util.UUID;

public interface TipoGastoService {

    ApiResponse saveTipoGasto(CrearTipoGastoDTO crearTipoGastoDTO);

    List<TipoGastoDTO> getTipoGastoList();

    ListResponse<TipoGastoDTO> getAllTipoGasto(UUID hospitalId, int page, int rows);

    TipoGastoDTO getTipoGastoById(UUID conceptoGastoId);

    ApiResponse updateTipoGasto(UUID conceptoGastoId, ActualizarTipoGastoDTO actualizarTipoGastoDTO);

    ApiResponse deleteTipoGasto(UUID conceptoGastoId);

}