package com.saludSystem.services.modules.Catalogo.Especialidad;

import com.saludSystem.dtos.catalago.Especialidad.ActualizarEspecialidadDTO;
import com.saludSystem.dtos.catalago.Especialidad.CrearEspecialidadDTO;
import com.saludSystem.dtos.catalago.Especialidad.EspecialidadDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;

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
