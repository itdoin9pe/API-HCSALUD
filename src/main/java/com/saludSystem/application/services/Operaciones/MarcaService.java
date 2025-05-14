package com.saludSystem.application.services.Operaciones;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarMarcaDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearMarcaDTO;
import com.saludSystem.application.dtos.Operaciones.GET.MarcaDTO;

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