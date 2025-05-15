package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.EstudioMedicoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearEstudioMedicoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarEstudioMedicoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface EstudioMedicoService {

    ApiResponse saveEstudioMedico(CrearEstudioMedicoDTO crearEstudioMedicoDTO);

    ListResponse<EstudioMedicoDTO> getAllEstudioMedico(UUID hospitalId, int page, int rows);

    ApiResponse updateEstudioMedico(Long pacienteEstudioMedicoId, ActualizarEstudioMedicoDTO actualizarEstudioMedicoDTO);

    EstudioMedicoDTO getEstudioMedicoById(Long pacienteEstudioMedicoId);

    ApiResponse deleteEstudioMedico(Long pacienteEstudioMedicoId);

}