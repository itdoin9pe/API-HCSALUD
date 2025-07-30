package com.saludsystem.submodules.core.configuracion.adapter.jpa.dao;

import com.saludsystem.submodules.core.configuracion.adapter.jpa.UserJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.UserDboMapper;
import com.saludsystem.submodules.configuracion.constant.UserConstant;
import com.saludsystem.submodules.configuracion.model.Usuario;
import com.saludsystem.submodules.configuracion.port.in.dao.UserDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserMysqlDao implements UserDao {

    private final UserJpaRepository userJpaRepository;

    public UserMysqlDao(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Usuario getById(UUID uuid) {
        return userJpaRepository.findById(uuid).map(UserDboMapper::toDomain).orElseThrow(
                () -> new ResourceNotFoundException(UserConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<Usuario> getAll(UUID hospitalId, int page, int rows) {

        var pageable = PageRequest.of(page - 1, rows);

        var pageResult = userJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);

        List<Usuario> data = pageResult.getContent().stream().map(UserDboMapper::toDomain).toList();

        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);

    }

    @Override
    public List<Usuario> getList() {
        return userJpaRepository.findAll().stream()
                .map(UserDboMapper::toDomain).toList();
    }
}