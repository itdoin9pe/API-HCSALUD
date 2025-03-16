package com.saludSystem.Generals.adapter.Aseguradora.aplicacion.services;

import com.saludSystem.Generals.adapter.Aseguradora.aplicacion.dtos.ActualizarAseguradoraDTO;
import com.saludSystem.Generals.adapter.Aseguradora.aplicacion.dtos.AseguradoraDTO;
import com.saludSystem.Generals.adapter.Aseguradora.aplicacion.dtos.CrearAseguradoraDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface AseguradoraService {

    ApiResponse saveAseguradora(CrearAseguradoraDTO crearAseguradoraDTO);

    List<AseguradoraDTO> getAseguradoraList();

    ListResponse<AseguradoraDTO> getAllAseguradoras(UUID hospitalId, int page, int rows);

    AseguradoraDTO getAseguradoraById(UUID aseguradoraId);

    ApiResponse updateAseguradora(UUID aseguradoraId, ActualizarAseguradoraDTO actualizarAseguradoraDTO);

    ApiResponse deleteAseguradora(UUID aseguradoraId);

}