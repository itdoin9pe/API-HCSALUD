package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarDiagnosticoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearDiagnosticoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.DiagnosticoDTO;

import java.util.List;
import java.util.UUID;

public interface DiagnosticoService {

    ApiResponse saveDiagnostico(CrearDiagnosticoDTO crearDiagnosticoDTO);

    List<DiagnosticoDTO> getDiagnosticoList();

    ListResponse<DiagnosticoDTO> getAllDiagnostico(UUID hospitalId, int page, int rows);

    ApiResponse updateDiagnostico(UUID diagnosticoId, ActualizarDiagnosticoDTO actualizarDiagnosticoDTO);

    DiagnosticoDTO getDiagnosticoById(UUID diagnosticoId);

    ApiResponse deleteDiagnostico(UUID diagnosticoId);

    List<DiagnosticoDTO> getDiagnosticosFiltradosPorRol();

}