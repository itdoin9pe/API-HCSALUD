package com.saludsystem.submodules.configuracion.port.out.dao;

import com.saludsystem.submodules.configuracion.model.entity.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    Usuario getById(UUID uuid);
    List<Usuario> getAll();
    Optional<Usuario> findByEmail(String email); // Nuevo método necesario para el login
    //long countByHospitalId(UUID hospitalId, int page, int rows);
}
