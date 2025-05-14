package com.saludSystem.application.services.Catalogo;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarAlergiaDTO;
import com.saludSystem.application.dtos.Catalogo.GET.AlergiaDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearAlergiaDTO;

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