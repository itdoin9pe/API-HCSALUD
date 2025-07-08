package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.CategoriaMatResponse;
import com.saludsystem.operaciones.application.dto.req.CategotiaMatRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CategoriaMatService extends GenericService<
        CategotiaMatRequest,
        CategoriaMatResponse,
        UUID> {
}