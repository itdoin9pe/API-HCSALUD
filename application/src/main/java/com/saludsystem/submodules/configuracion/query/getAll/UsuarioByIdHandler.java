package com.saludsystem.submodules.configuracion.query.getAll;

import com.saludsystem.submodules.configuracion.dtos.get.UsuarioDTO;
import com.saludsystem.submodules.configuracion.service.UserByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsuarioByIdHandler {

    private final UserByIdService byIdService;

    public UsuarioByIdHandler(UserByIdService byIdService) {
        this.byIdService = byIdService;
    }

    public UsuarioDTO execute(UUID uuid) {
        return byIdService.execute(uuid);
    }
}
