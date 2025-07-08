package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.ApoderadoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ApoderadoService extends GenericService<
        com.saludsystem.catalogo.application.dtos.req.ApoderadoRequest,
        ApoderadoRequest,
        UUID> {
}