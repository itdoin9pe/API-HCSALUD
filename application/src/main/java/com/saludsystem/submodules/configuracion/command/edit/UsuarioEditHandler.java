package com.saludsystem.submodules.configuracion.command.edit;

import com.saludsystem.submodules.configuracion.mapper.UsuarioMapper;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.UsuarioEditCommand;
import com.saludsystem.submodules.configuracion.service.user.UserEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsuarioEditHandler {

    private final UserEditService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioEditHandler(UserEditService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    public void execute(UUID uuid, UsuarioEditCommand dto) {

        var userUpdated = usuarioMapper.fromUpdateDto(uuid, dto);

        usuarioService.execute(uuid, userUpdated);

    }

}