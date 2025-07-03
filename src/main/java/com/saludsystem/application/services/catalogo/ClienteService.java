package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.get.ClienteDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearClienteDTO;
import com.saludsystem.application.dtos.catalogo.put.ActualizarClienteDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface ClienteService extends GenericService<
        ClienteDTO,
        UUID,
        CrearClienteDTO,
        ActualizarClienteDTO> {
}