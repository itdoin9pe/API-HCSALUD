package com.saludsystem.application.configuracion.command.create;

import com.saludsystem.domain.configuracion.port.in.service.UsuarioService;
import org.springframework.stereotype.Component;

@Component
public class UsuarioCreateHandler {
    private final UsuarioService usuarioService;

    public UsuarioCreateHandler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

}
