package com.saludsystem.submodules.configuracion.command.create;

import com.saludsystem.submodules.configuracion.mapper.UsuarioMapper;
import com.saludsystem.submodules.configuracion.model.Usuario;
import com.saludsystem.submodules.configuracion.model.dtos.auth.NewUserDto;
import com.saludsystem.submodules.configuracion.port.out.PasswordEncoderPort;
import com.saludsystem.submodules.configuracion.service.user.UserCreateService;
import org.springframework.stereotype.Component;

@Component
public class UsuarioCreateHandler {

    private final UserCreateService userCreateService;
    private final PasswordEncoderPort passwordEncoderPort;
    private final UsuarioMapper usuarioMapper;

    public UsuarioCreateHandler(UserCreateService userCreateService, PasswordEncoderPort passwordEncoderPort, UsuarioMapper usuarioMapper) {
        this.userCreateService = userCreateService;
        this.passwordEncoderPort = passwordEncoderPort;
        this.usuarioMapper = usuarioMapper;
    }

    public Usuario execute(NewUserDto dto) {

        dto.setPassword(passwordEncoderPort.encode(dto.getPassword()));

        var userSaved = usuarioMapper.fromCreateDto(dto);

        return userCreateService.execute(userSaved);

    }

}
