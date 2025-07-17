package com.saludsystem.submodules.configuracion.port.in.service.user;

import com.saludsystem.submodules.configuracion.port.out.dao.UserDao;
import com.saludsystem.submodules.configuracion.port.out.repository.UserRepository;

import java.util.UUID;

public class UserDeleteService {
    private final UserDao userDao;
    private final UserRepository userRepository;

    public UserDeleteService(UserDao userDao, UserRepository userRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    public void execute(UUID uuid) {
        var user = userDao.getById(uuid);
        userRepository.delete(user.getId().value());
    }
}
