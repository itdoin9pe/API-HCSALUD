package com.saludsystem.application.configuracion.command.edit;

import com.saludsystem.domain.configuracion.port.in.service.UsuarioService;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEditHandler {
    private final UsuarioService usuarioService;

    public UsuarioEditHandler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}