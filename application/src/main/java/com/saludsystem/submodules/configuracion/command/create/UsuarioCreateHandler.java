package com.saludsystem.submodules.configuracion.command.create;

import com.saludsystem.submodules.configuracion.dtos.post.NewUserDto;
import com.saludsystem.submodules.configuracion.service.UserCreateService;
import org.springframework.stereotype.Component;

@Component
public class UsuarioCreateHandler {

    private final UserCreateService userCreateService;

    public UsuarioCreateHandler(UserCreateService userCreateService) {
        this.userCreateService = userCreateService;
    }

    public void execute(NewUserDto dto) {
        userCreateService.execute(dto);
    }
}
