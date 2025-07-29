package com.saludsystem.submodules.configuracion.service;

import com.saludsystem.submodules.configuracion.port.in.repository.UserRepository;

import java.util.UUID;

public class UserDeleteService {

    private final UserRepository userRepository;

    public UserDeleteService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(UUID uuid) {
        userRepository.delete(uuid);
    }
}
