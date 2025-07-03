package com.saludsystem.application.services.paciente;

import com.saludsystem.application.dtos.paciente.get.EstudioMedicoDTO;
import com.saludsystem.application.dtos.paciente.post.CrearEstudioMedicoDTO;
import com.saludsystem.application.dtos.paciente.put.ActualizarEstudioMedicoDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface EstudioMedicoService {

    ApiResponse saveEstudioMedico(CrearEstudioMedicoDTO crearEstudioMedicoDTO);

    ListResponse<EstudioMedicoDTO> getAllEstudioMedico(UUID hospitalId, int page, int rows);

    ApiResponse updateEstudioMedico(Long pacienteEstudioMedicoId, ActualizarEstudioMedicoDTO actualizarEstudioMedicoDTO);

    EstudioMedicoDTO getEstudioMedicoById(Long pacienteEstudioMedicoId);

    ApiResponse deleteEstudioMedico(Long pacienteEstudioMedicoId);

}