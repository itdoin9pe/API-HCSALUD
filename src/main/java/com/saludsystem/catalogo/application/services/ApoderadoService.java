package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.get.ApoderadoDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearApoderadoDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarApoderadoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ApoderadoService extends GenericService<
        ApoderadoDTO,
        CrearApoderadoDTO,
        ActualizarApoderadoDTO,
        UUID> {
}