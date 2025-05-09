package com.saludSystem.application.services.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.ProcedimientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearProcedimientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarProcedimientoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface ProcedimientoService {

    ApiResponse saveProcedimiento(CrearProcedimientoDTO crearProcedimientoDTO);

    ListResponse<ProcedimientoDTO> getAllProcedimiento(UUID hospitalId, int page, int rows);

    ApiResponse updateProcedimiento(UUID pacienteProcedimientoId, ActualizarProcedimientoDTO actualizarProcedimientoDTO);

    ProcedimientoDTO getProcedimientoById(UUID pacienteProcedimientoId);

    ApiResponse deleteProcedimiento(UUID pacienteProcedimientoId);

}