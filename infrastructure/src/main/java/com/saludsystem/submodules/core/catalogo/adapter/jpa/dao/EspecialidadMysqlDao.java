package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.EspecialidadJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.EspecialidadDboMapper;
import com.saludsystem.submodules.response.ListResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EspecialidadMysqlDao implements EspecialidadDao {

    private final EspecialidadJpaRepository especialidadJpaRepository;

    public EspecialidadMysqlDao(EspecialidadJpaRepository especialidadJpaRepository) {
        this.especialidadJpaRepository = especialidadJpaRepository;
    }

    @Override
    public Especialidad getById(UUID uuid) {
        return especialidadJpaRepository.findById(uuid).map(EspecialidadDboMapper::toDomain).orElse(null);
    }

    @Override
    public ListResponse<Especialidad> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = especialidadJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Especialidad> data = pageResult.getContent()
                .stream()
                .map(EspecialidadDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
    }

    @Override
    public List<Especialidad> getList() {
        return especialidadJpaRepository.findAll().stream().map(EspecialidadDboMapper::toDomain).toList();
    }
}