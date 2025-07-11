package com.saludsystem.application.catalogo.command.create;

import com.saludsystem.application.catalogo.dtos.post.CrearClienteDTO;
import com.saludsystem.application.catalogo.mapper.ClienteMapper;
import com.saludsystem.domain.catalogo.port.in.service.ClienteService;
import org.springframework.stereotype.Component;

@Component
public class ClienteCreateHandler {

    private final ClienteService clienteService;

    public ClienteCreateHandler(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(CrearClienteDTO dto) {
        clienteService.save(ClienteMapper.fromCreateDTO(dto));
    }
}
