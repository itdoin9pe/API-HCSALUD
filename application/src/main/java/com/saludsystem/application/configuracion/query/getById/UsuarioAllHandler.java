package com.saludsystem.application.configuracion.query.getById;

import com.saludsystem.domain.configuracion.port.in.service.UsuarioService;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAllHandler {
    private final UsuarioService usuarioService;

    public UsuarioAllHandler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
