package com.saludsystem.submodules.configuracion.query.getById;

import com.saludsystem.submodules.configuracion.port.in.service.UsuarioService;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAllHandler {
    private final UsuarioService usuarioService;

    public UsuarioAllHandler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
