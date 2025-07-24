package com.saludsystem.submodules.configuracion.port.in.service.user;

import com.saludsystem.submodules.configuracion.model.entity.Usuario;
import com.saludsystem.submodules.configuracion.port.out.dao.UserDao;

import java.util.UUID;

public class UserByIdService {
    private final UserDao userDao;

    public UserByIdService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Usuario execute(UUID uuid) {
        return userDao.getById(uuid);
    }
}
