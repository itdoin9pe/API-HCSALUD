package com.saludsystem.application.configuracion.usecase;

import com.saludsystem.domain.configuracion.model.Usuario;
import com.saludsystem.domain.configuracion.port.in.service.UsuarioService;
import com.saludsystem.domain.configuracion.port.out.repository.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioUseCase implements UsuarioService {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioUseCase(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepositoryPort.save(usuario);
    }

    @Override
    public Usuario update(UUID uuid, Usuario usuario) {
        return usuarioRepositoryPort.update(uuid, usuario);
    }

    @Override
    public void delete(UUID uuid) {
        usuarioRepositoryPort.delete(uuid);
    }

    @Override
    public Usuario getById(UUID uuid) {
        return usuarioRepositoryPort.findById(uuid);
    }

    @Override
    public List<Usuario> getAll(UUID hospitalId, int page, int rows) {
        return usuarioRepositoryPort.findAll(hospitalId, page, rows);
    }
}
