package com.saludSystem.Catalogo.Especialidad.aplicacion.services;

import com.saludSystem.Catalogo.Especialidad.aplicacion.dtos.ActualizarEspecialidadDTO;
import com.saludSystem.Catalogo.Especialidad.aplicacion.dtos.CrearEspecialidadDTO;
import com.saludSystem.Catalogo.Especialidad.aplicacion.dtos.EspecialidadDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
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