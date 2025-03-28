package com.saludSystem.Operaciones.Unidad.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Operaciones.Unidad.aplicacion.dtos.ActualizarUnidadDTO;
import com.saludSystem.Operaciones.Unidad.aplicacion.dtos.CrearUnidadDTO;
import com.saludSystem.Operaciones.Unidad.aplicacion.dtos.UnidadDTO;

import java.util.List;
import java.util.UUID;

public interface UnidadService {

    ApiResponse saveUnidad(CrearUnidadDTO crearUnidadDTO);

    List<UnidadDTO> getUnidadList();

    UnidadDTO getUnidadById(UUID unidadId);

    ListResponse<UnidadDTO> getAllUnidad(UUID hospitalId, int page, int rows);

    ApiResponse updateUnidad(UUID unidadId, ActualizarUnidadDTO actualizarUnidadDTO);

    ApiResponse deleteUnidad(UUID unidadId);

}