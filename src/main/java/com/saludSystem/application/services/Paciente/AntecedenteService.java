package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.AntecedenteDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearAntecedenteDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarAntecedenteDTO;
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