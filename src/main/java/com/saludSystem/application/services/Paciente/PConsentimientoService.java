package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.PConsentimientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearPConsentimientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarPConsentimiento;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PConsentimientoService {

    ApiResponse savePConsentiemiento(CrearPConsentimientoDTO crearPConsentimientoDTO);

    List<PConsentimientoDTO> getPConsentimientoList();

    ListResponse<PConsentimientoDTO> getAllPConsentimiento(UUID hospitalId, int page, int rows);

    PConsentimientoDTO getPConsentimientoById(UUID pacienteConsentimientoId);

    ApiResponse updatePConsentimiento(UUID pacienteConsentimientoId, ActualizarPConsentimiento actualizarPConsentimiento);

    ApiResponse deletePConsentimiento(UUID pacienteConsentimientoId);

}