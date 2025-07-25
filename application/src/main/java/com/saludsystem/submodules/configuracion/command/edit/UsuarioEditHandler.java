package com.saludsystem.submodules.configuracion.command.edit;

import com.saludsystem.submodules.configuracion.dtos.put.ActualizarUsuarioDTO;
import com.saludsystem.submodules.configuracion.service.UserEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsuarioEditHandler {

    private final UserEditService usuarioService;

    public UsuarioEditHandler(UserEditService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(UUID uuid, ActualizarUsuarioDTO dto) {
        usuarioService.execute(uuid, dto);
    }

}