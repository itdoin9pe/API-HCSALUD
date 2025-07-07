package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.res.EstudioMedicoDTO;
import com.saludsystem.paciente.application.dto.req.CrearEstudioMedicoDTO;
import com.saludsystem.paciente.application.dto.ActualizarEstudioMedicoDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface EstudioMedicoService {

    ApiResponse saveEstudioMedico(CrearEstudioMedicoDTO crearEstudioMedicoDTO);

    ListResponse<EstudioMedicoDTO> getAllEstudioMedico(UUID hospitalId, int page, int rows);

    ApiResponse updateEstudioMedico(Long pacienteEstudioMedicoId, ActualizarEstudioMedicoDTO actualizarEstudioMedicoDTO);

    EstudioMedicoDTO getEstudioMedicoById(Long pacienteEstudioMedicoId);

    ApiResponse deleteEstudioMedico(Long pacienteEstudioMedicoId);

}