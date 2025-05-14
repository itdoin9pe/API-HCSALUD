package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarEnfermedadDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearEnfermedadDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.EnfermedadDTO;

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