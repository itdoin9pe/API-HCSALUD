package com.saludsystem.submodules.configuracion.port.out.dao;

import com.saludsystem.submodules.configuracion.model.entity.Usuario;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    Usuario getById(UUID uuid);
    List<Usuario> getAll();
    //long countByHospitalId(UUID hospitalId, int page, int rows);
}
