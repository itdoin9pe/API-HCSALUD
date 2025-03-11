package com.saludSystem.Catalogo.Apoderado.aplicacion.services;

import com.saludSystem.Catalogo.Apoderado.aplicacion.dtos.ActualizarApoderadoDTO;
import com.saludSystem.Catalogo.Apoderado.aplicacion.dtos.ApoderadoDTO;
import com.saludSystem.Catalogo.Apoderado.aplicacion.dtos.CrearApoderadoDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

import java.util.UUID;

public interface ApoderadoService {

    ApiResponse saveApoderado(CrearApoderadoDTO crearApoderadoDTO);

    ApiResponse updateApoderado(UUID apoderadoId, ActualizarApoderadoDTO actualizarApoderadoDTO);

    ListResponse<ApoderadoDTO> getAllApoderado(UUID hospitalId, int page, int rows);

    ApoderadoDTO getApoderadoById(UUID apoderadoId);

    ApiResponse deleteApoderado(UUID apoderadoId);

}