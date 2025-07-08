package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.res.EstudioMedicoResponse;
import com.saludsystem.paciente.application.dto.req.EstudioMedicoRequest;
import com.saludsystem.paciente.application.dto.ActualizarEstudioMedicoDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface EstudioMedicoService {

    ApiResponse saveEstudioMedico(EstudioMedicoRequest estudioMedicoRequest);

    ListResponse<EstudioMedicoResponse> getAllEstudioMedico(UUID hospitalId, int page, int rows);

    ApiResponse updateEstudioMedico(Long pacienteEstudioMedicoId, ActualizarEstudioMedicoDTO actualizarEstudioMedicoDTO);

    EstudioMedicoResponse getEstudioMedicoById(Long pacienteEstudioMedicoId);

    ApiResponse deleteEstudioMedico(Long pacienteEstudioMedicoId);

}