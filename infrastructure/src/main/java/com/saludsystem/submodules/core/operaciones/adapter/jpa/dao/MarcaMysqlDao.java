package com.saludsystem.submodules.core.operaciones.adapter.jpa.dao;

import com.saludsystem.submodules.core.operaciones.adapter.jpa.MarcaJpaRepository;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.MarcaDboMapper;
import com.saludsystem.submodules.operaciones.model.constant.MarcaConstant;
import com.saludsystem.submodules.operaciones.model.Marca;
import com.saludsystem.submodules.operaciones.port.dao.MarcaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MarcaMysqlDao implements MarcaDao {

    private final MarcaJpaRepository marcaJpaRepository;

    public MarcaMysqlDao(MarcaJpaRepository marcaJpaRepository) {
        this.marcaJpaRepository = marcaJpaRepository;
    }

    @Override
    public Marca getById(UUID uuid) {
        return marcaJpaRepository.findById(uuid)
                .map(MarcaDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(MarcaConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<Marca> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = marcaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Marca> data = pageResult.getContent()
                .stream()
                .map(MarcaDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Marca> getList() {
        return marcaJpaRepository.findAll()
                .stream()
                .map(MarcaDboMapper::toDomain)
                .toList();
    }

}
