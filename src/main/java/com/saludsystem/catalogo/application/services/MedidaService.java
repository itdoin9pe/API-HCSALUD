package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.MedidaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MedidaService extends GenericService<
        com.saludsystem.catalogo.application.dtos.req.MedidaRequest,
        MedidaRequest,
        UUID> {
}