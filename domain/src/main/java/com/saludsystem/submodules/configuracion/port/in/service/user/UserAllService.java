package com.saludsystem.submodules.configuracion.port.in.service.user;

import com.saludsystem.submodules.configuracion.model.entity.Usuario;
import com.saludsystem.submodules.configuracion.port.out.dao.UserDao;

import java.util.List;

public class UserAllService {
    private final UserDao userDao;

    public UserAllService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<Usuario> execute(){
        return userDao.getAll();
    }
}