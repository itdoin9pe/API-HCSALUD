package com.saludsystem.submodules.catalogo.service.cliente;

import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarClienteDTO;
import com.saludsystem.submodules.catalogo.port.repository.ClienteRepository;

import java.util.UUID;

public class ClienteEditService {

    private final ClienteRepository clienteRepository;

    public ClienteEditService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente execute(UUID uuid, ActualizarClienteDTO dto) {
        var updateToSave = ClienteMapper.fromUpdateDTO(uuid, dto);
        return clienteRepository.save(updateToSave);
    }
}
