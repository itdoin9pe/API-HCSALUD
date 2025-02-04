package com.saludSystem.services.modules.Catalogo.Especialidad;

import com.saludSystem.dtos.catalago.Especialidad.ActualizarEspecialidadDTO;
import com.saludSystem.dtos.catalago.Especialidad.CrearEspecialidadDTO;
import com.saludSystem.dtos.catalago.Especialidad.EspecialidadDTO;
import com.saludSystem.services.PaginatedService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EspecialidadService extends PaginatedService {

    CrearEspecialidadDTO saveEspecialidad(CrearEspecialidadDTO crearEspecialidadDTO);

    ActualizarEspecialidadDTO updateEspecialidad(UUID especialidadId, ActualizarEspecialidadDTO actualizarEspecialidadDTO);

    Optional<EspecialidadDTO> getEspecialidadById(UUID especialidadId);

    List<EspecialidadDTO> getEspecialidadList();

    void deleteEspecialidad(UUID especialidadId);

}
