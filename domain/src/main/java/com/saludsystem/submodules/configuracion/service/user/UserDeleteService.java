package com.saludsystem.submodules.configuracion.service.user;

import com.saludsystem.submodules.configuracion.port.in.dao.UserDao;
import com.saludsystem.submodules.configuracion.port.in.repository.UserRepository;

import java.util.UUID;

public class UserDeleteService {

    private final UserRepository userRepository;
    private final UserDao userDao;

    public UserDeleteService(UserRepository userRepository, UserDao userDao) {
        this.userRepository = userRepository;
        this.userDao = userDao;
    }

    public void execute(UUID uuid) {

        var user = userDao.getById(uuid);

        if (user.getEstado() != null) {

            throw new IllegalStateException("No se puede eliminar un usuario ya desactivado");

        }

        userRepository.delete(uuid);

    }

}
