package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.dao;

import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.TipoTarjetaJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.TipoTarjetaDboMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;
import com.saludsystem.submodules.mantenimiento.constant.TipoTarjetaConstant;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoTarjetaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoTarjetaMysqlDao implements TipoTarjetaDao {

    private final TipoTarjetaJpaRepository tipoTarjetaJpaRepository;

    public TipoTarjetaMysqlDao(TipoTarjetaJpaRepository tipoTarjetaJpaRepository) {
        this.tipoTarjetaJpaRepository = tipoTarjetaJpaRepository;
    }

    @Override
    public TipoTarjeta getById(UUID uuid) {
        return tipoTarjetaJpaRepository.findById(uuid).map(TipoTarjetaDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(TipoTarjetaConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<TipoTarjeta> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = tipoTarjetaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<TipoTarjeta> data = pageResult.getContent()
                .stream()
                .map(TipoTarjetaDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<TipoTarjeta> getList() {
        return tipoTarjetaJpaRepository.findAll()
                .stream()
                .map(TipoTarjetaDboMapper::toDomain)
                .toList();
    }
}
