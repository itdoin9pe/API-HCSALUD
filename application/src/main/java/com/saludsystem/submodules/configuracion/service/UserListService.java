package com.saludsystem.submodules.configuracion.service;

import com.saludsystem.submodules.configuracion.dtos.get.UsuarioDTO;
import com.saludsystem.submodules.configuracion.mapper.UsuarioMapper;
import com.saludsystem.submodules.configuracion.port.in.dao.UserDao;

import java.util.List;

public class UserListService {

    private final UserDao userDao;

    public UserListService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UsuarioDTO> execute() {
        return userDao.getList()
                .stream()
                .map(UsuarioMapper::toDto)
                .toList();
    }
}
