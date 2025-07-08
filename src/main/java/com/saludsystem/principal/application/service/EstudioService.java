package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.res.EstudioResponse;
import com.saludsystem.principal.application.dto.req.EstudioRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface EstudioService extends GenericService<
        EstudioRequest,
        EstudioResponse,
        UUID> {
}