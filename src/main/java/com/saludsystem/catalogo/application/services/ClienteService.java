package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.ClienteDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearClienteDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ClienteService extends GenericService<
        CrearClienteDTO,
        ClienteDTO,
        UUID> {
}