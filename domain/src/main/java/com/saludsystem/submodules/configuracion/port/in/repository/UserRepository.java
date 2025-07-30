package com.saludsystem.submodules.configuracion.port.in.repository;

import com.saludsystem.submodules.configuracion.model.Usuario;

import java.util.UUID;

public interface UserRepository {
    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(UUID uuid);
}