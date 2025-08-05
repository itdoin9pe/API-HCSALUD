package com.saludsystem.submodules.configuracion.service.rol;

import com.saludsystem.submodules.configuracion.port.in.dao.RolDao;
import com.saludsystem.submodules.configuracion.port.in.repository.RolRepository;

import java.util.UUID;

public class RolDeleteService {

    private final RolRepository rolRepository;
    private final RolDao rolDao;

    public RolDeleteService(RolRepository rolRepository, RolDao rolDao) {
        this.rolRepository = rolRepository;
        this.rolDao = rolDao;
    }

    public void execute(UUID uuid) {

        var rol = rolDao.getById(uuid);

        if (rol.getEstado() != null && rol.getEstado() == 0) {

            throw new IllegalStateException("No se puede eliminar un rol ya desactivado");

        }

        rolRepository.delete(uuid);

    }

}
