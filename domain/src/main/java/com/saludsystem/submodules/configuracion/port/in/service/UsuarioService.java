package com.saludsystem.submodules.configuracion.port.in.service;

import com.saludsystem.submodules.configuracion.model.entity.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    Usuario update(UUID uuid, Usuario usuario);
    void delete(UUID uuid);
    Usuario getById(UUID uuid);
    List<Usuario> getAll(UUID hospitalId, int page, int rows);
}