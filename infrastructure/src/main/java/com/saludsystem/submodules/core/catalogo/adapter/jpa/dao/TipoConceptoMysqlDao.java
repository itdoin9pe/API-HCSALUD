package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.TipoConceptoJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.TipoConceptoDboMapper;
import com.saludsystem.submodules.response.ListResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoConceptoMysqlDao implements TipoConceptoDao {

    private final TipoConceptoJpaRepository tipoConceptoJpaRepository;

    public TipoConceptoMysqlDao(TipoConceptoJpaRepository tipoConceptoJpaRepository) {
        this.tipoConceptoJpaRepository = tipoConceptoJpaRepository;
    }

    @Override
    public TipoConcepto getById(UUID uuid) {
        return tipoConceptoJpaRepository.findById(uuid).map(TipoConceptoDboMapper::toDomain).orElse(null);
    }

    @Override
    public ListResponse<TipoConcepto> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = tipoConceptoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<TipoConcepto> data = pageResult.getContent()
                .stream()
                .map(TipoConceptoDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);    }

    @Override
    public List<TipoConcepto> getList() {
        return tipoConceptoJpaRepository.findAll().stream().map(TipoConceptoDboMapper::toDomain).toList();
    }
}