package com.saludsystem.submodules.core.movimiento.adapter.jpa.dao;

import com.saludsystem.submodules.core.movimiento.adapter.jpa.VentaJpaRepository;
import com.saludsystem.submodules.core.movimiento.adapter.mapper.VentaDboMapper;
import com.saludsystem.submodules.movimiento.model.Venta;
import com.saludsystem.submodules.movimiento.model.constant.VentaConstant;
import com.saludsystem.submodules.movimiento.port.dao.VentaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@Transactional
public class VentaMysqlDao implements VentaDao {

    private final VentaJpaRepository ventaJpaRepository;

    public VentaMysqlDao(VentaJpaRepository ventaJpaRepository) {
        this.ventaJpaRepository = ventaJpaRepository;
    }

    @Override
    public Venta getById(UUID uuid) {
        return ventaJpaRepository.findById(uuid)
                .map(VentaDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(VentaConstant.INVALID_ID));
    }

    @Override
    public ListResponse<Venta> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = ventaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Venta> data = pageResult.getContent()
                .stream()
                .map(VentaDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Venta> getList() {
        return ventaJpaRepository.findAll()
                .stream()
                .map(VentaDboMapper::toDomain)
                .toList();
    }

}
