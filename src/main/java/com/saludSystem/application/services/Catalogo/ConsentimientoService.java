package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarConsentimientoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.ConsentimientoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearConsentimientoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface ConsentimientoService {

    ApiResponse saveConsentimiento(CrearConsentimientoDTO crearConsentimientoDTO);

    ApiResponse updateConsentimiento(UUID consentimientoId, ActualizarConsentimientoDTO actualizarConsentimientoDTO);

    ConsentimientoDTO getConsentimientoById(UUID consentimientoId);

    ApiResponse deleteConsentimiento(UUID consentimientoId);

    ListResponse<ConsentimientoDTO> getAllConsentimiento(UUID hospitalId, int page, int rows);

}