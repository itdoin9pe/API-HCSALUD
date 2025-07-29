package com.saludsystem.submodules.configuracion.service;

import com.saludsystem.submodules.configuracion.dtos.post.NewUserDto;
import com.saludsystem.submodules.configuracion.mapper.UsuarioMapper;
import com.saludsystem.submodules.configuracion.model.entity.Usuario;
import com.saludsystem.submodules.configuracion.port.repository.UserRepository;

public class UserCreateService {

    private final UserRepository userRepository;

    public UserCreateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Usuario execute(NewUserDto dto) {
        var userSaved = UsuarioMapper.fromCreateDto(dto);
        return userRepository.saveSinSeguridad(userSaved);
    }

}
