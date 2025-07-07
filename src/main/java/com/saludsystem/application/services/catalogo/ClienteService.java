package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.req.ClienteDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearClienteDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface ClienteService extends GenericService<
        CrearClienteDTO,
        ClienteDTO,
        UUID> {
}