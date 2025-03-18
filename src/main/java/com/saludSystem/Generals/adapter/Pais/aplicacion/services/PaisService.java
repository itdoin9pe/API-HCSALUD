package com.saludSystem.Generals.adapter.Pais.aplicacion.services;


import com.saludSystem.Generals.adapter.Pais.aplicacion.dtos.CrearPaisDTO;
import com.saludSystem.Generals.adapter.Pais.aplicacion.dtos.PaisDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PaisService {

    ApiResponse savePais(CrearPaisDTO crearPaisDTO);

    ListResponse<PaisDTO> getAllPais(UUID hospitalId, int page, int rows);

    List<PaisDTO> getPaisList();

}