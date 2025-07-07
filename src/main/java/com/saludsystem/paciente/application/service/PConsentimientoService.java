package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.res.PConsentimientoDTO;
import com.saludsystem.paciente.application.dto.req.CrearPConsentimientoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PConsentimientoService extends GenericService<
        CrearPConsentimientoDTO,
        PConsentimientoDTO,
        UUID> {
}