package com.saludsystem.application.catalogo.query.getAll;

import com.saludsystem.application.catalogo.dtos.get.ClienteDTO;
import com.saludsystem.application.catalogo.mapper.ClienteMapper;
import com.saludsystem.domain.catalogo.model.Cliente;
import com.saludsystem.domain.catalogo.port.in.service.ClienteService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ClienteAllHandler {
    private final ClienteService clienteService;

    public ClienteAllHandler(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<ClienteDTO> execute(UUID hospitalId, int page, int rows) {
        List<Cliente> models = clienteService.getAll(hospitalId, page, rows);
        return models.stream().map(ClienteMapper::toDto).toList();
    }
}
