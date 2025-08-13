package com.saludsystem.submodules.core.principal.adapter.jpa.dao;

import com.saludsystem.submodules.core.principal.adapter.jpa.SucursalJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.SucursalDboMapper;
import com.saludsystem.submodules.principal.model.Sucursal;
import com.saludsystem.submodules.principal.model.constant.SucursalConstant;
import com.saludsystem.submodules.principal.port.dao.SucursalDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SucursalMysqlDao implements SucursalDao {

    private final SucursalJpaRepository sucursalJpaRepository;

    public SucursalMysqlDao(SucursalJpaRepository sucursalJpaRepository) {
        this.sucursalJpaRepository = sucursalJpaRepository;
    }

    @Override
    public Sucursal getById(UUID uuid) {
        return sucursalJpaRepository.findById(uuid)
                .map(SucursalDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(SucursalConstant.INVALID_ID));
    }

    @Override
    public ListResponse<Sucursal> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = sucursalJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Sucursal> data = pageResult.getContent()
                .stream()
                .map(SucursalDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Sucursal> getList() {
        return sucursalJpaRepository.findAll()
                .stream()
                .map(SucursalDboMapper::toDomain)
                .toList();
    }
}
