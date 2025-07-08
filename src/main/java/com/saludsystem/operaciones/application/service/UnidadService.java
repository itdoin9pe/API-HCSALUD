package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.UnidadResponse;
import com.saludsystem.operaciones.application.dto.req.UnidadRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface  UnidadService  extends GenericService<
        UnidadRequest,
        UnidadResponse,
        UUID> {
}