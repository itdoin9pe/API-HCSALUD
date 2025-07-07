package com.saludsystem.application.services.principal;

import com.saludsystem.application.dtos.principal.res.EstudioDTO;
import com.saludsystem.application.dtos.principal.req.CrearEstudioDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface EstudioService extends GenericService<
        CrearEstudioDTO,
        EstudioDTO,
        UUID> {
}