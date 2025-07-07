package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.res.EstudioDTO;
import com.saludsystem.principal.application.dto.req.CrearEstudioDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface EstudioService extends GenericService<
        CrearEstudioDTO,
        EstudioDTO,
        UUID> {
}