package com.saludsystem.submodules.configuracion.query.getAll;

import com.saludsystem.submodules.configuracion.mapper.UsuarioDtoMapper;
import com.saludsystem.submodules.configuracion.model.dto.UserDto;
import com.saludsystem.submodules.configuracion.port.in.service.user.UserByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsuarioByIdHandler {
    private final UserByIdService byIdService;
    private final UsuarioDtoMapper usuarioDtoMapper;

    public UsuarioByIdHandler(UserByIdService byIdService, UsuarioDtoMapper usuarioDtoMapper) {
        this.byIdService = byIdService;
        this.usuarioDtoMapper = usuarioDtoMapper;
    }

    public UserDto execute(UUID uuid) {
        return usuarioDtoMapper.toDto(byIdService.execute(uuid));
    }
}
