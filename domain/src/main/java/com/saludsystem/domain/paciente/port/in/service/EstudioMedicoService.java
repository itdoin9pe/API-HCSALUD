package com.saludsystem.domain.paciente.port.in.service;

import com.saludsystem.application.dto.get.EstudioMedicoDTO;
import com.saludsystem.application.dto.post.CrearEstudioMedicoDTO;
import com.saludsystem.application.dto.put.ActualizarEstudioMedicoDTO;
import com.shared.infrastructure.adapters.in.response.ApiResponse;
import com.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface EstudioMedicoService {

    ApiResponse saveEstudioMedico(CrearEstudioMedicoDTO crearEstudioMedicoDTO);

    ListResponse<EstudioMedicoDTO> getAllEstudioMedico(UUID hospitalId, int page, int rows);

    ApiResponse updateEstudioMedico(Long pacienteEstudioMedicoId, ActualizarEstudioMedicoDTO actualizarEstudioMedicoDTO);

    EstudioMedicoDTO getEstudioMedicoById(Long pacienteEstudioMedicoId);

    ApiResponse deleteEstudioMedico(Long pacienteEstudioMedicoId);

}