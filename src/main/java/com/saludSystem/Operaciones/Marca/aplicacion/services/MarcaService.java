package com.saludSystem.Operaciones.Marca.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Operaciones.Marca.aplicacion.dtos.ActualizarMarcaDTO;
import com.saludSystem.Operaciones.Marca.aplicacion.dtos.CrearMarcaDTO;
import com.saludSystem.Operaciones.Marca.aplicacion.dtos.MarcaDTO;

import java.util.List;
import java.util.UUID;

public interface MarcaService {

    ApiResponse saveMarca(CrearMarcaDTO crearMarcaDTO);

    List<MarcaDTO> getMarcaList();

    ListResponse<MarcaDTO> getAllMarca(UUID hospitalId, int page, int rows);

    MarcaDTO getMarcaById(UUID marcaId);

    ApiResponse updateMarca(UUID marcaId, ActualizarMarcaDTO actualizarMarcaDTO);

    ApiResponse deleteMarca(UUID marcaId);

}