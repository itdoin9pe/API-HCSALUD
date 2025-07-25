package com.saludsystem.submodules.configuracion.service;

import com.saludsystem.submodules.configuracion.dtos.get.UsuarioDTO;
import com.saludsystem.submodules.configuracion.mapper.UsuarioMapper;
import com.saludsystem.submodules.configuracion.port.dao.UserDao;

import java.util.UUID;

public class UserByIdService {

    private final UserDao userDao;

    public UserByIdService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UsuarioDTO execute(UUID uuid) {
        return UsuarioMapper.toDto(userDao.getById(uuid));
    }
}
