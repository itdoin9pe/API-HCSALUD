package com.saludsystem.catalogo.application.services;

import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.catalogo.application.dtos.res.AlergiaResponse;
import com.saludsystem.catalogo.application.dtos.req.AlergiaRequest;

import java.util.UUID;

public interface AlergiaService extends GenericService<
        AlergiaRequest,
        AlergiaResponse,
        UUID> {
}