package com.saludsystem.submodules.core.configuracion.adapter.jpa.dao;

import com.saludsystem.submodules.configuracion.model.Sede;
import com.saludsystem.submodules.configuracion.model.constant.SedeConstant;
import com.saludsystem.submodules.configuracion.port.in.dao.SedeDao;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.SedeJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.SedeDboMapper;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SedeMysqlDao implements SedeDao {

    private final SedeJpaRepository sedeJpaRepository;

    public SedeMysqlDao(SedeJpaRepository sedeJpaRepository) {
        this.sedeJpaRepository = sedeJpaRepository;
    }

    @Override
    public Sede getById(UUID uuid) {
        return sedeJpaRepository.findById(uuid)
                .map(SedeDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(SedeConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<Sede> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = sedeJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Sede> data = pageResult.getContent()
                .stream()
                .map(SedeDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Sede> getList() {
        return sedeJpaRepository.findAll()
                .stream()
                .map(SedeDboMapper::toDomain)
                .toList();
    }
}
