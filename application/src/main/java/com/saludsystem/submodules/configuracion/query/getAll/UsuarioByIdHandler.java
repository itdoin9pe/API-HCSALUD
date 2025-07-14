package com.saludsystem.submodules.configuracion.query.getAll;

import com.saludsystem.submodules.configuracion.port.in.service.UsuarioService;
import org.springframework.stereotype.Component;

@Component
public class UsuarioByIdHandler {
    private final UsuarioService usuarioService;

    public UsuarioByIdHandler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
