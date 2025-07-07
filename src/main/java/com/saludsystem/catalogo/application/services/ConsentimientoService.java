package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.ConsentimientoDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearConsentimientoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ConsentimientoService extends GenericService<
        CrearConsentimientoDTO,
        ConsentimientoDTO,
        UUID> {
}