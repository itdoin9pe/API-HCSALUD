package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.get.EnfermedadDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearEnfermedadDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarEnfermedadDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface EnfermedadService {

    ApiResponse saveEnfermedad(CrearEnfermedadDTO crearEnfermedadDTO);

    List<EnfermedadDTO> getEnfermedadList();

    ListResponse<EnfermedadDTO> getAllEnfermedad(UUID hospitalId, int page, int rows);

    ApiResponse updateEnfermedad(String enfermedadId, ActualizarEnfermedadDTO actualizarEnfermedadDTO);

    EnfermedadDTO getEnfermedadById(String enfermedadId);

    ApiResponse deleteEnfermedad(String enfermedadId);

    List<EnfermedadDTO> getEnfermedadFiltradosPorRol();

}