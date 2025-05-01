package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.AnalisisFacialDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearAnalisisFacialDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarAnalisisFacialDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface AnalisisFacialService {

    ApiResponse saveAnalisisFacil(CrearAnalisisFacialDTO crearAnalisisFacialDTO);

    ApiResponse updateAnalisisFacial(UUID pacienteAnalisisFacialId, ActualizarAnalisisFacialDTO actualizarAnalisisFacialDTO);

    ListResponse<AnalisisFacialDTO> getAllAnalisisFacial(UUID hospitalId, int page, int rows);

    AnalisisFacialDTO getAnalisisFacialById(UUID pacienteAnalisisFacialId);

    ApiResponse deleteAnalisisFacial(UUID pacienteAnalisisFacialId);

}