package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.dao;

import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.MonedaJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.MonedaDboMapper;
import com.saludsystem.submodules.mantenimiento.model.Moneda;
import com.saludsystem.submodules.mantenimiento.port.dao.MonedaDao;
import com.saludsystem.submodules.response.ListResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MonedaMysqlDao implements MonedaDao {

    private final MonedaJpaRepository monedaJpaRepository;

    public MonedaMysqlDao(MonedaJpaRepository monedaJpaRepository) {
        this.monedaJpaRepository = monedaJpaRepository;
    }

    @Override
    public Moneda getById(UUID uuid) {
        return monedaJpaRepository.findById(uuid).map(MonedaDboMapper::toDomain).orElse(null);
    }

    @Override
    public ListResponse<Moneda> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = monedaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Moneda> data = pageResult.getContent()
                .stream()
                .map(MonedaDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Moneda> getList() {
        return monedaJpaRepository.findAll()
                .stream()
                .map(MonedaDboMapper::toDomain)
                .toList();
    }
}
