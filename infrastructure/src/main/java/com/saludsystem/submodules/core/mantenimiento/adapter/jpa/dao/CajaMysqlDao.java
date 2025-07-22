package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.dao;

import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.CajaJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.CajaDboMapper;
import com.saludsystem.submodules.mantenimiento.model.Caja;
import com.saludsystem.submodules.mantenimiento.port.dao.CajaDao;
import com.saludsystem.submodules.response.ListResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CajaMysqlDao implements CajaDao {

    private final CajaJpaRepository cajaJpaRepository;

    public CajaMysqlDao(CajaJpaRepository cajaJpaRepository) {
        this.cajaJpaRepository = cajaJpaRepository;
    }

    @Override
    public Caja getById(UUID uuid) {
        return cajaJpaRepository.findById(uuid).map(CajaDboMapper::toDomain).orElse(null);
    }

    @Override
    public ListResponse<Caja> getAll(UUID hospitalId, int page, int rows) {

        var pageable = PageRequest.of(page - 1, rows);

        var pageResult = cajaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);

        List<Caja> data = pageResult.getContent().stream()
                .map(CajaDboMapper::toDomain)
                .toList();

        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Caja> getList() {
        return cajaJpaRepository.findAll().stream().map(CajaDboMapper::toDomain).toList();
    }
}
