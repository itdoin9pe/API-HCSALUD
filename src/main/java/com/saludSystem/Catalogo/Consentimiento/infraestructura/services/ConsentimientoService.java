package com.saludSystem.Catalogo.Consentimiento.infraestructura.services;

import com.saludSystem.Catalogo.Consentimiento.aplicacion.dtos.ActualizarConsentimientoDTO;
import com.saludSystem.Catalogo.Consentimiento.aplicacion.dtos.ConsentimientoDTO;
import com.saludSystem.Catalogo.Consentimiento.aplicacion.dtos.CrearConsentimientoDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

import java.util.UUID;

public interface ConsentimientoService {

    ApiResponse saveConsentimiento(CrearConsentimientoDTO crearConsentimientoDTO);

    ApiResponse updateConsentimiento(UUID consentimientoId, ActualizarConsentimientoDTO actualizarConsentimientoDTO);

    ConsentimientoDTO getConsentimientoById(UUID consentimientoId);

    ApiResponse deleteConsentimiento(UUID consentimientoId);

    ListResponse<ConsentimientoDTO> getAllConsentimiento(UUID hospitalId, int page, int rows);

}