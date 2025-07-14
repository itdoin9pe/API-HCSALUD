package com.saludsystem.submodules.configuracion.port.out.repository;

import com.saludsystem.submodules.configuracion.model.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepositoryPort {
    Usuario save(Usuario usuario);
    Usuario update(UUID uuid, Usuario usuario);
    void delete(UUID uuid);
    Usuario findById(UUID uuid);
    List<Usuario> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}