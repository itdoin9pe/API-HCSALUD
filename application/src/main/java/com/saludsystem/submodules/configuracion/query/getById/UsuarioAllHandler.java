package com.saludsystem.submodules.configuracion.query.getById;

import com.saludsystem.submodules.configuracion.mapper.UsuarioDtoMapper;
import com.saludsystem.submodules.configuracion.model.dto.UserDto;
import com.saludsystem.submodules.configuracion.port.in.service.user.UserAllService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UsuarioAllHandler {
    private final UserAllService userAllService;
    private final UsuarioDtoMapper usuarioDtoMapper;

    public UsuarioAllHandler(UserAllService userAllService, UsuarioDtoMapper usuarioDtoMapper) {
        this.userAllService = userAllService;
        this.usuarioDtoMapper = usuarioDtoMapper;
    }

    public List<UserDto> execute(UUID uuid) {
        return userAllService.execute().stream().map(usuarioDtoMapper::toDto).toList();
    }
}
