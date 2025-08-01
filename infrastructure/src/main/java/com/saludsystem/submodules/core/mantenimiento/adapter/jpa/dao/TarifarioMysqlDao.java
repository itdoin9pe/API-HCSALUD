package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.dao;

import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.TarifarioJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.TarifarioDboMapper;
import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.mantenimiento.model.constant.TarifarioConstant;
import com.saludsystem.submodules.mantenimiento.port.dao.TarifarioDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TarifarioMysqlDao implements TarifarioDao {

    private final TarifarioJpaRepository tarifarioJpaRepository;

    public TarifarioMysqlDao(TarifarioJpaRepository tarifarioJpaRepository) {
        this.tarifarioJpaRepository = tarifarioJpaRepository;
    }

    @Override
    public Tarifario getById(UUID uuid) {
        return tarifarioJpaRepository.findById(uuid).map(TarifarioDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(TarifarioConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<Tarifario> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = tarifarioJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Tarifario> data = pageResult.getContent()
                .stream()
                .map(TarifarioDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Tarifario> getList() {
        return tarifarioJpaRepository.findAll()
                .stream()
                .map(TarifarioDboMapper::toDomain)
                .toList();
    }
}
