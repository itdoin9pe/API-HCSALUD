package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.MedicamentoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MedicamentoService extends GenericService<
        com.saludsystem.catalogo.application.dtos.req.MedicamentoRequest,
        MedicamentoRequest,
        UUID> {
}