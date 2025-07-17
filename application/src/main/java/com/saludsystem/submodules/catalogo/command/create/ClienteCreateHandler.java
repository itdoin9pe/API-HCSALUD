package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearClienteDTO;
import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import org.springframework.stereotype.Component;

@Component
public class ClienteCreateHandler {

    private final ClienteDao clienteService;

    public ClienteCreateHandler(ClienteDao clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(CrearClienteDTO dto) {
        clienteService.save(ClienteMapper.fromCreateDTO(dto));
    }
}
