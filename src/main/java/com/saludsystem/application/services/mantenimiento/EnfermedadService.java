package com.saludsystem.application.services.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.EnfermedadDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearEnfermedadDTO;
import com.saludsystem.application.dtos.mantenimiento.put.ActualizarEnfermedadDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

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