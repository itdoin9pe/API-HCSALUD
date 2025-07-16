package com.saludsystem.submodules.configuracion.command.create;

import com.saludsystem.submodules.configuracion.mapper.UsuarioDtoMapper;
import com.saludsystem.submodules.configuracion.model.dto.UserDto;
import com.saludsystem.submodules.configuracion.model.dto.command.create.UserCreateCommand;
import com.saludsystem.submodules.configuracion.port.in.service.user.UserCreateService;
import org.springframework.stereotype.Component;

@Component
public class UsuarioCreateHandler {
    private final UserCreateService userCreateService;
    private final UsuarioDtoMapper usuarioDtoMapper;

    public UsuarioCreateHandler(UserCreateService userCreateService, UsuarioDtoMapper usuarioDtoMapper) {
        this.userCreateService = userCreateService;
        this.usuarioDtoMapper = usuarioDtoMapper;
    }

    public UserDto execute(UserCreateCommand userCreateCommand) {
        return usuarioDtoMapper.toDto(userCreateService.execute(userCreateCommand));
    }
}
