package com.saludsystem.submodules.core.operaciones.adapter.jpa.dao;

import com.saludsystem.submodules.core.operaciones.adapter.jpa.TipoMaterialJpaRepository;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.TipoMaterialDboMapper;
import com.saludsystem.submodules.operaciones.model.TipoMaterial;
import com.saludsystem.submodules.operaciones.model.constant.TipoMaterialConstant;
import com.saludsystem.submodules.operaciones.port.dao.TipoMaterialDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoMaterialMysqlDao implements TipoMaterialDao {

    private final TipoMaterialJpaRepository tipoMaterialJpaRepository;

    public TipoMaterialMysqlDao(TipoMaterialJpaRepository tipoMaterialJpaRepository) {
        this.tipoMaterialJpaRepository = tipoMaterialJpaRepository;
    }

    @Override
    public TipoMaterial getById(UUID uuid) {
        return tipoMaterialJpaRepository.findById(uuid)
                .map(TipoMaterialDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(TipoMaterialConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<TipoMaterial> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = tipoMaterialJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<TipoMaterial> data = pageResult.getContent()
                .stream()
                .map(TipoMaterialDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<TipoMaterial> getList() {
        return tipoMaterialJpaRepository.findAll()
                .stream()
                .map(TipoMaterialDboMapper::toDomain)
                .toList();
    }

}
