package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.RecetaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.RecetaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.RecetaConstant;
import com.saludsystem.submodules.paciente.model.entity.Receta;
import com.saludsystem.submodules.paciente.port.dao.RecetaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RecetaMysqlDao implements RecetaDao {

    private final RecetaJpaRepository recetaJpaRepository;

    public RecetaMysqlDao(RecetaJpaRepository recetaJpaRepository) {
        this.recetaJpaRepository = recetaJpaRepository;
    }

    @Override
    public Receta getById(UUID uuid) {

        return recetaJpaRepository.findById(uuid)
                .map(RecetaDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(RecetaConstant.INVALID_ID));

    }

    @Override
    public ListResponse<Receta> getAll(UUID hospitalId, int page, int rows) {

        var pageable = PageRequest.of(page - 1, rows);

        var pageResult = recetaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);

        List<Receta> data = pageResult.getContent()
                .stream()
                .map(RecetaDboMapper::toDomain)
                .toList();

        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);

    }

    @Override
    public List<Receta> getList() {

        return recetaJpaRepository.findAll()
                .stream()
                .map(RecetaDboMapper::toDomain)
                .toList();

    }
}
