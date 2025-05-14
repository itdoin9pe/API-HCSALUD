package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarEspecialidadDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearEspecialidadDTO;
import com.saludSystem.application.dtos.Catalogo.GET.EspecialidadDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import java.util.List;
import java.util.UUID;

public interface EspecialidadService {

    ApiResponse saveEspecialidad(CrearEspecialidadDTO crearEspecialidadDTO);

    ApiResponse updateEspecialidad(UUID especialidadId, ActualizarEspecialidadDTO actualizarEspecialidadDTO);

    EspecialidadDTO getEspecialidadById(UUID especialidadId);

    List<EspecialidadDTO> getEspecialidadList();

    ApiResponse deleteEspecialidad(UUID especialidadId);

    ListResponse<EspecialidadDTO> getAllEspecialidad(UUID hospitalId, int page, int rows);

}