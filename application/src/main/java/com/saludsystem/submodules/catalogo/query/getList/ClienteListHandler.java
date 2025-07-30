package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.model.dto.ClienteCreateCommand;
import com.saludsystem.submodules.catalogo.service.cliente.ClienteListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteListHandler {

    private final ClienteListService clienteListService;

    public ClienteListHandler(ClienteListService clienteListService) {
        this.clienteListService = clienteListService;
    }

    public List<ClienteCreateCommand> execute() {
        return clienteListService.execute();
    }
}