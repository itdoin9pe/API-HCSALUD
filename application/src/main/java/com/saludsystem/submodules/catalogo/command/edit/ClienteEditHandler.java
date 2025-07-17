package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarClienteDTO;
import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteEditHandler {
    private final ClienteDao clienteService;

    public ClienteEditHandler(ClienteDao clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(UUID uuid, ActualizarClienteDTO dto){
        clienteService.update(uuid, ClienteMapper.fromUpdateDTO(uuid, dto));
    }
}