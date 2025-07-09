package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.get.EstudioMedicoDTO;
import com.saludsystem.paciente.application.dto.post.CrearEstudioMedicoDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarEstudioMedicoDTO;
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