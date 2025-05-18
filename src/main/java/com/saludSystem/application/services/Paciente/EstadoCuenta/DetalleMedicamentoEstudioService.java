package com.saludSystem.application.services.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.DetalleMedicamentoEstudioDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarDetalleMedicamentoEstudioDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface DetalleMedicamentoEstudioService {

    ApiResponse saveDetalleMedicamentoEstudio(CrearDetalleMedicamentoEstudioDTO crearDetalleMedicamentoEstudioDTO);

    ListResponse<DetalleMedicamentoEstudioDTO> getAllDetalleMedicamentoEstudio(UUID hospitalId, int page, int rows);

    ApiResponse updateDetalleMedicamento(UUID pec_detalleMedicamentoId, ActualizarDetalleMedicamentoEstudioDTO actualizarDetalleMedicamentoEstudioDTO);

    DetalleMedicamentoEstudioDTO getDetalleMedicamentoById(UUID pec_detalleMedicamentoId);

    ApiResponse deleteDetalleMedicamentoEstudio(UUID pec_detalleMedicamentoId);

}