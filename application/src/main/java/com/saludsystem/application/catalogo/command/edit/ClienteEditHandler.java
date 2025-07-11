package com.saludsystem.application.catalogo.command.edit;

import com.saludsystem.application.catalogo.dtos.put.ActualizarClienteDTO;
import com.saludsystem.application.catalogo.mapper.ClienteMapper;
import com.saludsystem.domain.catalogo.port.in.service.ClienteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteEditHandler {
    private final ClienteService clienteService;

    public ClienteEditHandler(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(UUID uuid, ActualizarClienteDTO dto){
        clienteService.update(uuid, ClienteMapper.fromUpdateDTO(uuid, dto));
    }
}