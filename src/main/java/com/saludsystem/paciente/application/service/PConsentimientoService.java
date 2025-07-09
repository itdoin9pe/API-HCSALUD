package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.get.PConsentimientoDTO;
import com.saludsystem.paciente.application.dto.post.CrearPConsentimientoDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarPConsentimientoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PConsentimientoService extends GenericService<
        PConsentimientoDTO,
        CrearPConsentimientoDTO,
        ActualizarPConsentimientoDTO,
        UUID> {
}