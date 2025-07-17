package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.ClienteDTO;
import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ClienteAllHandler {
    private final ClienteDao clienteService;

    public ClienteAllHandler(ClienteDao clienteService) {
        this.clienteService = clienteService;
    }

    public List<ClienteDTO> execute(UUID hospitalId, int page, int rows) {
        List<Cliente> models = clienteService.getAll(hospitalId, page, rows);
        return models.stream().map(ClienteMapper::toDto).toList();
    }
}
