package com.saludSystem.Catalogo.Alergia.aplicacion.services;

import com.saludSystem.Catalogo.Alergia.aplicacion.dtos.ActualizarAlergiaDTO;
import com.saludSystem.Catalogo.Alergia.aplicacion.dtos.AlergiaDTO;
import com.saludSystem.Catalogo.Alergia.aplicacion.dtos.CrearAlergiaDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface AlergiaService {

    ApiResponse saveAlergia(CrearAlergiaDTO crearAlergiaDTO);

    List<AlergiaDTO> getAlergiaList();

    ApiResponse deleteAlergia(UUID alergiaId);

    ApiResponse updateAlergia(UUID alergiaId, ActualizarAlergiaDTO actualizarAlergiaDTO);

    AlergiaDTO getAlergiaById(UUID alergiaId);

    ListResponse<AlergiaDTO> getAllAlergia(UUID hospitalId, int page, int rows);

}