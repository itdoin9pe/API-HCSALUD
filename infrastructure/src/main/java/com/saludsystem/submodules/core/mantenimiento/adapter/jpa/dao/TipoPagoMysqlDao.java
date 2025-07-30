package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.dao;

import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.TipoPagoJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.TipoPagoDboMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoPago;
import com.saludsystem.submodules.mantenimiento.constant.TipoGastoConstant;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoPagoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoPagoMysqlDao implements TipoPagoDao {

    private final TipoPagoJpaRepository tipoPagoJpaRepository;

    public TipoPagoMysqlDao(TipoPagoJpaRepository tipoPagoJpaRepository) {
        this.tipoPagoJpaRepository = tipoPagoJpaRepository;
    }

    @Override
    public TipoPago getById(UUID uuid) {
        return tipoPagoJpaRepository.findById(uuid)
                .map(TipoPagoDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(TipoGastoConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<TipoPago> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = tipoPagoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<TipoPago> data = pageResult.getContent()
                .stream()
                .map(TipoPagoDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<TipoPago> getList() {
        return tipoPagoJpaRepository.findAll()
                .stream()
                .map(TipoPagoDboMapper::toDomain)
                .toList();
    }
}
