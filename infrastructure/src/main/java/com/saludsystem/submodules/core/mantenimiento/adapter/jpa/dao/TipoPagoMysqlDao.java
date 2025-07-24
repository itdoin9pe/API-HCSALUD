package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.dao;

import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.TipoGastoJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.TipoGastoDboMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoGasto;
import com.saludsystem.submodules.mantenimiento.model.constant.TipoGastoConstant;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoGastoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoPagoMysqlDao implements TipoGastoDao {

    private final TipoGastoJpaRepository tipoGastoJpaRepository;

    public TipoPagoMysqlDao(TipoGastoJpaRepository tipoGastoJpaRepository) {
        this.tipoGastoJpaRepository = tipoGastoJpaRepository;
    }

    @Override
    public TipoGasto getById(UUID uuid) {
        return tipoGastoJpaRepository.findById(uuid)
                .map(TipoGastoDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(TipoGastoConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<TipoGasto> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = tipoGastoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<TipoGasto> data = pageResult.getContent()
                .stream()
                .map(TipoGastoDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<TipoGasto> getList() {
        return tipoGastoJpaRepository.findAll()
                .stream()
                .map(TipoGastoDboMapper::toDomain)
                .toList();
    }
}
