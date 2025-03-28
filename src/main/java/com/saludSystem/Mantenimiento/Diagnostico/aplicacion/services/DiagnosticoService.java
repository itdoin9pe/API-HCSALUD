package com.saludSystem.Mantenimiento.Diagnostico.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.Diagnostico.aplicacion.dtos.ActualizarDiagnosticoDTO;
import com.saludSystem.Mantenimiento.Diagnostico.aplicacion.dtos.CrearDiagnosticoDTO;
import com.saludSystem.Mantenimiento.Diagnostico.aplicacion.dtos.DiagnosticoDTO;

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