package com.saludsystem.submodules.configuracion.command.delete;

import com.saludsystem.submodules.configuracion.port.in.service.user.UserDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsuarioDeleteHandler {

    private final UserDeleteService userDeleteService;

    public UsuarioDeleteHandler(UserDeleteService userDeleteService) {
        this.userDeleteService = userDeleteService;
    }

    public void execute(UUID uuid) {
        userDeleteService.execute(uuid);
    }
}