package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.ApoderadoDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearApoderadoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ApoderadoService extends GenericService<
        CrearApoderadoDTO,
        ApoderadoDTO,
        UUID> {
}