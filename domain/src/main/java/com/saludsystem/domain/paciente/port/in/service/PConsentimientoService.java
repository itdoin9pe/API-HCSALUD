package com.saludsystem.domain.paciente.port.in.service;

import com.saludsystem.application.dto.get.PConsentimientoDTO;
import com.saludsystem.application.dto.post.CrearPConsentimientoDTO;
import com.saludsystem.application.dto.put.ActualizarPConsentimientoDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface PConsentimientoService extends GenericService<
        PConsentimientoDTO,
        CrearPConsentimientoDTO,
        ActualizarPConsentimientoDTO,
        UUID> {
}