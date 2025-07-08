package com.saludsystem.cita.application.service;

import com.saludsystem.cita.application.dto.res.CitaResponse;
import com.saludsystem.cita.application.dto.req.CitaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CitaService extends GenericService<
        CitaRequest,
        CitaResponse,
        UUID> {
}