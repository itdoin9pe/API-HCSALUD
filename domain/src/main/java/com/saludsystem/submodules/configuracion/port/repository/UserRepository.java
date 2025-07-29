package com.saludsystem.submodules.configuracion.port.repository;

import com.saludsystem.submodules.configuracion.model.entity.Usuario;

import java.util.UUID;

public interface UserRepository {
    Usuario saveSinSeguridad(Usuario usuario);
    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(UUID uuid);
    long count(); // agrega este método
}