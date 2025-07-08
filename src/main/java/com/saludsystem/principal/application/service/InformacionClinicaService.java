package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.res.InformacionClinicaResponse;
import com.saludsystem.principal.application.dto.req.InformacionClinicaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface InformacionClinicaService extends GenericService<
        InformacionClinicaRequest,
        InformacionClinicaResponse,
        UUID> {
}