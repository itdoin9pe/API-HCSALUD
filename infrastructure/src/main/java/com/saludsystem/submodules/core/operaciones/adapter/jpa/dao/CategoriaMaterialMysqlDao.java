package com.saludsystem.submodules.core.operaciones.adapter.jpa.dao;

import com.saludsystem.submodules.core.operaciones.adapter.jpa.CategoriaMatJpaRepository;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.CategoriaMaterialDboMapper;
import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;
import com.saludsystem.submodules.operaciones.constant.CategoriaMaterialConstant;
import com.saludsystem.submodules.operaciones.port.dao.CategoriaMaterialDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CategoriaMaterialMysqlDao implements CategoriaMaterialDao {

    private final CategoriaMatJpaRepository categoriaMatJpaRepository;

    public CategoriaMaterialMysqlDao(CategoriaMatJpaRepository categoriaMatJpaRepository) {
        this.categoriaMatJpaRepository = categoriaMatJpaRepository;
    }

    @Override
    public CategoriaMaterial getById(UUID uuid) {
        return categoriaMatJpaRepository.findById(uuid).map(CategoriaMaterialDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(CategoriaMaterialConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<CategoriaMaterial> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = categoriaMatJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<CategoriaMaterial> data = pageResult.getContent()
                .stream()
                .map(CategoriaMaterialDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<CategoriaMaterial> getList() {
        return categoriaMatJpaRepository.findAll()
                .stream()
                .map(CategoriaMaterialDboMapper::toDomain)
                .toList();
    }
}
