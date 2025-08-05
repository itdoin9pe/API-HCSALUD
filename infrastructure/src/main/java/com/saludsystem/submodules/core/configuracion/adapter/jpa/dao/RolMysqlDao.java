package com.saludsystem.submodules.core.configuracion.adapter.jpa.dao;

import com.saludsystem.submodules.configuracion.model.Rol;
import com.saludsystem.submodules.configuracion.model.constant.RolConstant;
import com.saludsystem.submodules.configuracion.port.in.dao.RolDao;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.RoleJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.RolDboMapper;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RolMysqlDao implements RolDao {

    private final RoleJpaRepository roleJpaRepository;

    public RolMysqlDao(RoleJpaRepository roleJpaRepository) {
        this.roleJpaRepository = roleJpaRepository;
    }

    @Override
    public Rol getById(UUID uuid) {

        return roleJpaRepository.findById(uuid)
                .map(RolDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(RolConstant.ID_NOT_FOUND));

    }

    @Override
    public ListResponse<Rol> getAll(UUID hospitalId, int page, int rows) {

        var pageable = PageRequest.of(page - 1, rows);

        var pageResult = roleJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);

        List<Rol> data = pageResult.getContent()
                .stream()
                .map(RolDboMapper::toDomain)
                .toList();

        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);

    }

    @Override
    public List<Rol> getList() {

        return roleJpaRepository.findAll()
                .stream()
                .map(RolDboMapper::toDomain)
                .toList();

    }

}
