package com.saludSystem.aplicacion.services.modules.Catalogo.Especialidad;

import com.saludSystem.aplicacion.dtos.Catalogo.Especialidad.ActualizarEspecialidadDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Especialidad.CrearEspecialidadDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Especialidad.EspecialidadDTO;
import com.saludSystem.aplicacion.dtos.responses.ApiResponse;
import com.saludSystem.aplicacion.dtos.responses.ListResponse;

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