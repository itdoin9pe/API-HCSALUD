package com.saludsystem.submodules.core.configuracion.adapter.jpa.dao;

import com.saludsystem.submodules.configuracion.model.SysSalud;
import com.saludsystem.submodules.configuracion.model.constant.ClinicaConstant;
import com.saludsystem.submodules.configuracion.port.in.dao.SysSaludDao;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.SysSaludJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.ClinicaDboMapper;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ClinicaMysqlDao implements SysSaludDao {

    private final SysSaludJpaRepository sysSaludJpaRepository;

    public ClinicaMysqlDao(SysSaludJpaRepository sysSaludJpaRepository) {
        this.sysSaludJpaRepository = sysSaludJpaRepository;
    }

    @Override
    public SysSalud getById(UUID uuid) {
        return sysSaludJpaRepository.findById(uuid)
                .map(ClinicaDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(ClinicaConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<SysSalud> getAll(UUID hospitalId, int page, int rows) {

        var pageable = PageRequest.of(page - 1, rows);

        var pageResult = sysSaludJpaRepository.findByHospitalId(hospitalId, pageable);

        List<SysSalud> data = pageResult.getContent()
                .stream()
                .map(ClinicaDboMapper::toDomain)
                .toList();

        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);

    }

    @Override
    public List<SysSalud> getList() {

        return sysSaludJpaRepository.findAll()
                .stream()
                .map(ClinicaDboMapper::toDomain)
                .toList();

    }

}
