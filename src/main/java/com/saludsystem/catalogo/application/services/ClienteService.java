package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.ClienteRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ClienteService extends GenericService<
        com.saludsystem.catalogo.application.dtos.req.ClienteRequest,
        ClienteRequest,
        UUID> {
}