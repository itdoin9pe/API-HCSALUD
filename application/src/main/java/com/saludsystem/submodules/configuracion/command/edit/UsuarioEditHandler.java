package com.saludsystem.submodules.configuracion.command.edit;

import com.saludsystem.submodules.configuracion.mapper.UsuarioDtoMapper;
import com.saludsystem.submodules.configuracion.model.dto.UserDto;
import com.saludsystem.submodules.configuracion.model.dto.command.edit.UserEditCommand;
import com.saludsystem.submodules.configuracion.port.in.service.user.UserEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsuarioEditHandler {
    private final UserEditService usuarioService;
    private final UsuarioDtoMapper usuarioDtoMapper;

    public UsuarioEditHandler(UserEditService usuarioService, UsuarioDtoMapper usuarioDtoMapper) {
        this.usuarioService = usuarioService;
        this.usuarioDtoMapper = usuarioDtoMapper;
    }

    public UserDto execute(UserEditCommand userEditCommand, UUID uuid) {
        return usuarioDtoMapper.toDto(usuarioService.execute(userEditCommand, uuid));
    }
}