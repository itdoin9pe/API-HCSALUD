package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.ProveedorResponse;
import com.saludsystem.operaciones.application.dto.req.ProveedorRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ProveedorService extends GenericService<
        ProveedorRequest,
        ProveedorResponse,
        UUID> {
}