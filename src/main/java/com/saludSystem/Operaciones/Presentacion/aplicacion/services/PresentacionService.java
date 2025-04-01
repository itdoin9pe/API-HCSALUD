package com.saludSystem.Operaciones.Presentacion.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Operaciones.Presentacion.aplicacion.dtos.ActualizarPresentacionDTO;
import com.saludSystem.Operaciones.Presentacion.aplicacion.dtos.CrearPresentacionDTO;
import com.saludSystem.Operaciones.Presentacion.aplicacion.dtos.PresentacionDTO;

import java.util.List;
import java.util.UUID;

public interface PresentacionService {

    ApiResponse savePresentacion(CrearPresentacionDTO crearPresentacionDTO);

    PresentacionDTO getPresentacionById(UUID presentacionId);

    ListResponse<PresentacionDTO> getAllPresentacion(UUID hospitalId, int page, int rows);

    List<PresentacionDTO> getPresentacionList();

    ApiResponse updatePresentacion(UUID presentacionId, ActualizarPresentacionDTO actualizarPresentacionDTO);

    ApiResponse deletePresentacion(UUID presentacionId);

}
