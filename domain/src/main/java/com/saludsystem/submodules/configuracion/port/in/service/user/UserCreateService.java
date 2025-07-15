package com.saludsystem.submodules.configuracion.port.in.service.user;

import com.saludsystem.submodules.configuracion.model.dto.command.UserCreateCommand;
import com.saludsystem.submodules.configuracion.model.entity.Usuario;
import com.saludsystem.submodules.configuracion.port.out.repository.UserRepository;

public class UserCreateService {
    private final UserRepository userRepository;

    public UserCreateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Usuario execute(UserCreateCommand userCreateCommand) {
        var userToCreate = new Usuario().requestToCreate(userCreateCommand);
        return userRepository.save(userToCreate);
    }
}
