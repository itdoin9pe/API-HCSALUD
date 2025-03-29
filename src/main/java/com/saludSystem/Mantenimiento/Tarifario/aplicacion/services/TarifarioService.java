package com.saludSystem.Mantenimiento.Tarifario.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.Tarifario.aplicacion.dtos.ActualizarTarifarioDTO;
import com.saludSystem.Mantenimiento.Tarifario.aplicacion.dtos.CrearTarifarioDTO;
import com.saludSystem.Mantenimiento.Tarifario.aplicacion.dtos.TarifarioDTO;

import java.util.List;
import java.util.UUID;

public interface TarifarioService {

    ApiResponse saveTarifario(CrearTarifarioDTO crearTarifarioDTO);

    ListResponse<TarifarioDTO> getAllTarifario(UUID hospitalId, int page, int rows);

    List<TarifarioDTO> getTarifarioList();

    TarifarioDTO getTarifarioById(UUID tarifarioId);

    ApiResponse updateTarifario(UUID tarifarioId, ActualizarTarifarioDTO actualizarTarifarioDTO);

    ApiResponse deleteTarifario(UUID tarifarioId);

}