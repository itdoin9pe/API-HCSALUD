package com.saludsystem.application.configuracion.command.delete;

import com.saludsystem.domain.configuracion.port.in.service.UsuarioService;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDeleteHandler {
    private final UsuarioService usuarioService;

    public UsuarioDeleteHandler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
