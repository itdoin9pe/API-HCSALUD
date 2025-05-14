package com.saludSystem.application.services.Operaciones;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarPresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearPresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.GET.PresentacionDTO;
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