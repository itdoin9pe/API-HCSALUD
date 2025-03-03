package com.saludSystem.application.services.modules.Catalogo.Especialidad;

import com.saludSystem.application.dtos.catalago.Especialidad.ActualizarEspecialidadDTO;
import com.saludSystem.application.dtos.catalago.Especialidad.CrearEspecialidadDTO;
import com.saludSystem.application.dtos.catalago.Especialidad.EspecialidadDTO;
import com.saludSystem.application.dtos.responses.ApiResponse;
import com.saludSystem.application.dtos.responses.ListResponse;

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