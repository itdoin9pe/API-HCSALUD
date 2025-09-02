package com.saludsystem.submodules.core.catalogo.adapter.jpa.repository;

import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.port.repository.ClienteRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.catalogo.adapter.entity.ClienteEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.ClienteJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.ClienteDboMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteMysqlRepository implements ClienteRepository {

    private final ClienteJpaRepository clienteJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public ClienteMysqlRepository(ClienteJpaRepository clienteJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.clienteJpaRepository = clienteJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Cliente save(Cliente cliente) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ClienteEntity entity = ClienteDboMapper.toEntity(cliente, userId, hospitalId);
        return ClienteDboMapper.toDomain(clienteJpaRepository.save(entity));
    }

    @Override
    public Cliente update(UUID uuid, Cliente cliente) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ClienteEntity entity = ClienteDboMapper.toEntity(cliente, userId, hospitalId);
        return ClienteDboMapper.toDomain(clienteJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        clienteJpaRepository.deleteById(uuid);
    }
}
