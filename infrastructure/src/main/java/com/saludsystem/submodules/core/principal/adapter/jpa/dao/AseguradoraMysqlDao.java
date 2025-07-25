package com.saludsystem.submodules.core.principal.adapter.jpa.dao;

import com.saludsystem.submodules.core.principal.adapter.jpa.AseguradoraJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.AseguradoraDboMapper;
import com.saludsystem.submodules.principal.model.Aseguradora;
import com.saludsystem.submodules.principal.model.constant.AseguradoraConstant;
import com.saludsystem.submodules.principal.port.dao.AseguradoraDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AseguradoraMysqlDao implements AseguradoraDao {

    private final AseguradoraJpaRepository aseguradoraJpaRepository;

    public AseguradoraMysqlDao(AseguradoraJpaRepository aseguradoraJpaRepository) {
        this.aseguradoraJpaRepository = aseguradoraJpaRepository;
    }

    @Override
    public Aseguradora getById(UUID uuid) {
        return aseguradoraJpaRepository.findById(uuid).map(AseguradoraDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(AseguradoraConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<Aseguradora> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = aseguradoraJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Aseguradora> data = pageResult.getContent()
                .stream()
                .map(AseguradoraDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Aseguradora> getList() {
        return aseguradoraJpaRepository.findAll()
                .stream()
                .map(AseguradoraDboMapper::toDomain)
                .toList();
    }
}
