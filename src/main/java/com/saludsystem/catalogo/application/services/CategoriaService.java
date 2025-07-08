package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.CategoriaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CategoriaService extends GenericService<
        com.saludsystem.catalogo.application.dtos.req.CategoriaRequest,
        CategoriaRequest,
        UUID> {
}