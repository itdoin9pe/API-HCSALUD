package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.EnfermedadDTO;
import com.saludsystem.mantenimiento.application.dto.req.EnfermedadRequest;
import com.saludsystem.mantenimiento.application.dto.res.EnfermedadResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface EnfermedadService {

    ApiResponse saveEnfermedad(EnfermedadRequest enfermedadRequest);

    List<EnfermedadDTO> getEnfermedadList();

    ListResponse<EnfermedadDTO> getAllEnfermedad(UUID hospitalId, int page, int rows);

    ApiResponse updateEnfermedad(String enfermedadId, EnfermedadResponse enfermedadResponse);

    EnfermedadDTO getEnfermedadById(String enfermedadId);

    ApiResponse deleteEnfermedad(String enfermedadId);

    List<EnfermedadDTO> getEnfermedadFiltradosPorRol();

}