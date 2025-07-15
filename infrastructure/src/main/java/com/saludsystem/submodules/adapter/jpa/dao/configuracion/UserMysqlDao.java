package com.saludsystem.submodules.adapter.jpa.dao.configuracion;

import com.saludsystem.submodules.adapter.jpa.interfaces.configuracion.UserJpaRepository;
import com.saludsystem.submodules.adapter.mapper.configuracion.UserDboMapper;
import com.saludsystem.submodules.configuracion.model.constant.UserConstant;
import com.saludsystem.submodules.configuracion.model.entity.Usuario;
import com.saludsystem.submodules.configuracion.model.exception.UserException;
import com.saludsystem.submodules.configuracion.port.out.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserMysqlDao implements UserDao {

    private final UserJpaRepository userJpaRepository;
    private final UserDboMapper userDboMapper;

    public UserMysqlDao(UserJpaRepository userJpaRepository, UserDboMapper userDboMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userDboMapper = userDboMapper;
    }

    @Override
    public Usuario getById(UUID uuid) {
        var optionalUser = userJpaRepository.findById(uuid);
        if (optionalUser.isEmpty()) {
            throw new UserException(String.format(UserConstant.TASK_NOT_FOUND_MESSAGE_ERROR));
        }
        return userDboMapper.toDomain(optionalUser.get());
    }

    @Override
    public List<Usuario> getAll() {
        return userJpaRepository.findAll().stream().map(userDboMapper::toDomain).toList();
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return Optional.empty();
    }
}