package com.saludsystem.submodules.core.movimiento.adapter.jpa.dao;

import com.saludsystem.submodules.core.movimiento.adapter.jpa.CompraJpaRepository;
import com.saludsystem.submodules.core.movimiento.adapter.mapper.CompraDboMapper;
import com.saludsystem.submodules.movimiento.model.Compra;
import com.saludsystem.submodules.movimiento.model.constant.CompraConstant;
import com.saludsystem.submodules.movimiento.port.dao.CompraDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CompraMysqlDao implements CompraDao {

    private final CompraJpaRepository compraJpaRepository;

    public CompraMysqlDao(CompraJpaRepository compraJpaRepository) {
        this.compraJpaRepository = compraJpaRepository;
    }

    @Override
    public Compra getById(UUID uuid) {
        return compraJpaRepository.findById(uuid)
                .map(CompraDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(CompraConstant.INVALID_ID));
    }

    @Override
    public ListResponse<Compra> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = compraJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Compra> data = pageResult.getContent()
                .stream()
                .map(CompraDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Compra> getList() {
        return compraJpaRepository.findAll()
                .stream()
                .map(CompraDboMapper::toDomain)
                .toList();
    }

}
