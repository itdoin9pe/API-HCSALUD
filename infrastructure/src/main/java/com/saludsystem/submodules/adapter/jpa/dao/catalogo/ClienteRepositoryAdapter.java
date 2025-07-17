package com.saludsystem.submodules.adapter.jpa.dao.catalogo;

import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.port.repository.ClienteRepository;
import com.saludsystem.submodules.adapter.entity.catalogo.ClienteEntity;
import com.saludsystem.submodules.adapter.jpa.interfaces.catalogo.ClienteJpaRepository;
import com.saludsystem.submodules.adapter.mapper.catalogo.ClienteDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ClienteRepositoryAdapter implements ClienteRepository {

    private final ClienteJpaRepository clienteJpaRepository;

    public ClienteRepositoryAdapter(ClienteJpaRepository clienteJpaRepository) {
        this.clienteJpaRepository = clienteJpaRepository;
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity entity = ClienteDboMapper.toEntity(cliente);
        return ClienteDboMapper.toDomain(clienteJpaRepository.save(entity));
    }

    @Override
    public Cliente update(UUID uuid, Cliente cliente) {
        ClienteEntity entity = ClienteDboMapper.toEntity(cliente);
        return ClienteDboMapper.toDomain(clienteJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        clienteJpaRepository.deleteById(uuid);
    }

    @Override
    public Cliente findById(UUID uuid) {
        return clienteJpaRepository.findById(uuid).map(ClienteDboMapper::toDomain).orElse(null);
    }

    @Override
    public List<Cliente> findAll(UUID hospitalId, int page, int rows) {
        return clienteJpaRepository.findAllByHospital_HospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(ClienteDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return clienteJpaRepository.countByHospital_HospitalId(hospitalId);
    }
}
