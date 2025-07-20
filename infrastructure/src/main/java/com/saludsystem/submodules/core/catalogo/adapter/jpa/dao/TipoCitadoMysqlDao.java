package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.TipoCitadoJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.TipoCitadoDboMapper;
import com.saludsystem.submodules.response.ListResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoCitadoMysqlDao implements TipoCitadoDao {

    private final TipoCitadoJpaRepository tipoCitadoJpaRepository;

    public TipoCitadoMysqlDao(TipoCitadoJpaRepository tipoCitadoJpaRepository) {
        this.tipoCitadoJpaRepository = tipoCitadoJpaRepository;
    }

    @Override
    public TipoCitado getById(UUID uuid) {
        return tipoCitadoJpaRepository.findById(uuid).map(TipoCitadoDboMapper::toDomain).orElse(null);
    }

    @Override
    public ListResponse<TipoCitado> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = tipoCitadoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<TipoCitado> data = pageResult.getContent().stream()
                .map(TipoCitadoDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<TipoCitado> getList() {
        return tipoCitadoJpaRepository.findAll().stream()
                .map(TipoCitadoDboMapper::toDomain).toList();
    }
}
