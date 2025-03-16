package com.saludSystem.Generals.adapter.Estudio.aplicacion.services;


import com.saludSystem.Generals.adapter.Estudio.aplicacion.dtos.ActualizarEstudioDTO;
import com.saludSystem.Generals.adapter.Estudio.aplicacion.dtos.CrearEstudioDTO;
import com.saludSystem.Generals.adapter.Estudio.aplicacion.dtos.EstudioDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface EstudioService {

    ApiResponse saveEstudio(CrearEstudioDTO crearEstudioDTO);

    EstudioDTO getEstudioById(UUID estudioId);

    ApiResponse deleteEstudio(UUID estudioId);

    ListResponse<EstudioDTO> getAllEstudios(UUID hospitalId, int page, int rows);

    ApiResponse updateEstudio(UUID estudioId, ActualizarEstudioDTO actualizarEstudioDTO);

    List<EstudioDTO> getEstudioList();

}