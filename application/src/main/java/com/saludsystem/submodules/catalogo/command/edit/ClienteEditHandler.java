package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dtos.put.ActualizarClienteDTO;
import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.port.in.service.ClienteService;
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