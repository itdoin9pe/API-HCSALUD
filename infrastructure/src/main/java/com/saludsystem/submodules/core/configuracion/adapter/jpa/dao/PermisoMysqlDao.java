package com.saludsystem.submodules.core.configuracion.adapter.jpa.dao;

import com.saludsystem.submodules.configuracion.model.Permiso;
import com.saludsystem.submodules.configuracion.model.constant.PermisoConstant;
import com.saludsystem.submodules.configuracion.port.in.dao.PermisoDao;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.PermisoJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.PermisoDboMapper;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PermisoMysqlDao implements PermisoDao {

    private final PermisoJpaRepository permisoJpaRepository;

    public PermisoMysqlDao(PermisoJpaRepository permisoJpaRepository) {
        this.permisoJpaRepository = permisoJpaRepository;
    }

    @Override
    public Permiso getById(UUID uuid) {
        return permisoJpaRepository.findById(uuid)
                .map(PermisoDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(PermisoConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<Permiso> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = permisoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Permiso> data = pageResult.getContent()
                .stream()
                .map(PermisoDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Permiso> getList() {
        return permisoJpaRepository.findAll()
                .stream()
                .map(PermisoDboMapper::toDomain)
                .toList();
    }

}
