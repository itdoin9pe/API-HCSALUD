package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.ClienteCreateCommand;
import com.saludsystem.submodules.catalogo.service.cliente.ClienteAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteAllHandler {

    private final ClienteAllService clienteAllService;

    public ClienteAllHandler(ClienteAllService clienteAllService) {
        this.clienteAllService = clienteAllService;
    }

    public ListResponse<ClienteCreateCommand> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return clienteAllService.execute(hospitalId, paginationRequest);
    }
}
