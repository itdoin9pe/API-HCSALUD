package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.catalogo.application.dtos.get.ClienteDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearClienteDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarClienteDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ClienteService extends GenericService<
        ClienteDTO,
        CrearClienteDTO,
        ActualizarClienteDTO,
        UUID> {
}