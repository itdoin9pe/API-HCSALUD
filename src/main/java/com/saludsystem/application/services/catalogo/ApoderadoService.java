package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.req.ApoderadoDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearApoderadoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface ApoderadoService extends GenericService<
        CrearApoderadoDTO,
        ApoderadoDTO,
        UUID> {
}