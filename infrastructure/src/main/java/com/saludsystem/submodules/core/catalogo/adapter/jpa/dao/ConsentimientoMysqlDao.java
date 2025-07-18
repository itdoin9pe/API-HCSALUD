package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.ConsentimientoJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.ConsentimientoDboMapper;
import com.saludsystem.submodules.response.ListResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ConsentimientoMysqlDao implements ConsentimientoDao {

    private final ConsentimientoJpaRepository consentimientoJpaRepository;

    public ConsentimientoMysqlDao(ConsentimientoJpaRepository consentimientoJpaRepository) {
        this.consentimientoJpaRepository = consentimientoJpaRepository;
    }

    @Override
    public Consentimiento getById(UUID uuid) {
        return consentimientoJpaRepository.findById(uuid).map(ConsentimientoDboMapper::toDomain).orElse(null);
    }

    @Override
    public ListResponse<Consentimiento> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = consentimientoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Consentimiento> data = pageResult.getContent().stream().map(ConsentimientoDboMapper::toDomain).toList();
        return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
    }

    @Override
    public List<Consentimiento> getList() {
        return consentimientoJpaRepository.findAll().stream().map(ConsentimientoDboMapper::toDomain).toList();
    }
}
