package com.saludsystem.submodules.configuracion.service;

import com.saludsystem.submodules.configuracion.dtos.put.ActualizarUsuarioDTO;
import com.saludsystem.submodules.configuracion.mapper.UsuarioMapper;
import com.saludsystem.submodules.configuracion.model.entity.Usuario;
import com.saludsystem.submodules.configuracion.port.repository.UserRepository;

import java.util.UUID;

public class UserEditService {

    private final UserRepository userRepository;

    public UserEditService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Usuario execute(UUID uuid, ActualizarUsuarioDTO dto) {

        var userToSave = UsuarioMapper.fromUpdateDto(uuid, dto);

        return userRepository.update(userToSave);

    }
}
