package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.ClienteJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.ClienteDboMapper;
import com.saludsystem.submodules.response.ListResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ClienteMysqlDao implements ClienteDao {

    private final ClienteJpaRepository clienteJpaRepository;

    public ClienteMysqlDao(ClienteJpaRepository clienteJpaRepository) {
        this.clienteJpaRepository = clienteJpaRepository;
    }

    @Override
    public Cliente getById(UUID uuid) {
        return clienteJpaRepository.findById(uuid).map(ClienteDboMapper::toDomain).orElse(null);
    }

    @Override
    public ListResponse<Cliente> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = clienteJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Cliente> data = pageResult.getContent().stream().map(ClienteDboMapper::toDomain).toList();
        return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
    }

    @Override
    public List<Cliente> getList() {
        return clienteJpaRepository.findAll().stream().map(ClienteDboMapper::toDomain).toList();
    }
}
