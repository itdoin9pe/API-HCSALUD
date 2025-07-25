package com.saludsystem.submodules.core.principal.adapter.jpa.dao;

import com.saludsystem.submodules.core.principal.adapter.jpa.EmpresaJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.EmpresaDboMapper;
import com.saludsystem.submodules.principal.model.Empresa;
import com.saludsystem.submodules.principal.model.constant.EmpresaConstant;
import com.saludsystem.submodules.principal.port.dao.EmpresaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EmpresaMysqlDao implements EmpresaDao {

    private final EmpresaJpaRepository empresaJpaRepository;

    public EmpresaMysqlDao(EmpresaJpaRepository empresaJpaRepository) {
        this.empresaJpaRepository = empresaJpaRepository;
    }

    @Override
    public Empresa getById(UUID uuid) {
        return empresaJpaRepository.findById(uuid).map(EmpresaDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(EmpresaConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<Empresa> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = empresaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Empresa> data = pageResult.getContent()
                .stream()
                .map(EmpresaDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Empresa> getList() {
        return empresaJpaRepository.findAll()
                .stream()
                .map(EmpresaDboMapper::toDomain)
                .toList();
    }

}
