package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.ConsentimientoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ConsentimientoService extends GenericService<
        com.saludsystem.catalogo.application.dtos.req.ConsentimientoRequest,
        ConsentimientoRequest,
        UUID> {
}