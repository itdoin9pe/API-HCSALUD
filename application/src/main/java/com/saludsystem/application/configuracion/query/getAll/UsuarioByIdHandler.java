package com.saludsystem.application.configuracion.query.getAll;

import com.saludsystem.domain.configuracion.port.in.service.UsuarioService;
import org.springframework.stereotype.Component;

@Component
public class UsuarioByIdHandler {
    private final UsuarioService usuarioService;

    public UsuarioByIdHandler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
