package com.saludsystem.submodules.configuracion.service;

import com.saludsystem.submodules.configuracion.dtos.post.NewUserDto;
import com.saludsystem.submodules.configuracion.mapper.UsuarioMapper;
import com.saludsystem.submodules.configuracion.model.Usuario;
import com.saludsystem.submodules.configuracion.port.out.PasswordEncoderPort;
import com.saludsystem.submodules.configuracion.port.in.repository.UserRepository;

public class UserCreateService {

    private final UserRepository userRepository;
    private final PasswordEncoderPort passwordEncoderPort;

    public UserCreateService(UserRepository userRepository, PasswordEncoderPort passwordEncoderPort) {
        this.userRepository = userRepository;
        this.passwordEncoderPort = passwordEncoderPort;
    }

    public Usuario execute(NewUserDto dto) {

        dto.setPassword(passwordEncoderPort.encode(dto.getPassword()));

        var userSaved = UsuarioMapper.fromCreateDto(dto);

        return userRepository.save(userSaved);

    }

}
