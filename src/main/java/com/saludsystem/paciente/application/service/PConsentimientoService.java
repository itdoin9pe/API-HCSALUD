package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.res.PConsentimientoResponse;
import com.saludsystem.paciente.application.dto.req.PConsentimientoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PConsentimientoService extends GenericService<
        PConsentimientoRequest,
        PConsentimientoResponse,
        UUID> {
}