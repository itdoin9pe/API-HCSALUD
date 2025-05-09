package com.saludSystem.application.services.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.AntecedenteDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearAntecedenteDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarAntecedenteDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface AntecedenteService {

    ApiResponse saveAntecedentes(CrearAntecedenteDTO crearAntecedenteDTO);

    ApiResponse updateAntecentes(UUID antecedenteId, ActualizarAntecedenteDTO actualizarAntecedenteDTO);

    AntecedenteDTO getAntecedenteById(UUID antecedenteId);

    ListResponse<AntecedenteDTO> getAllAntecedentes(UUID hospitalId, int page, int rows);

    ApiResponse deleteAntecedente(UUID antecedenteId);

}