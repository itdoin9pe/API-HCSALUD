package com.saludsystem.submodules.configuracion.service.permiso;

import com.saludsystem.submodules.configuracion.model.Permiso;
import com.saludsystem.submodules.configuracion.model.constant.PermisoConstant;
import com.saludsystem.submodules.configuracion.port.in.dao.PermisoDao;
import com.saludsystem.submodules.configuracion.port.in.repository.PermisoRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PermisoEditService {

    private final PermisoDao permisoDao;
    private final PermisoRepository permisoRepository;

    public PermisoEditService(PermisoDao permisoDao, PermisoRepository permisoRepository) {
        this.permisoDao = permisoDao;
        this.permisoRepository = permisoRepository;
    }

    public Permiso execute(UUID uuid, Permiso permiso) {

        var currentPermiso = permisoDao.getById(uuid);

        if (currentPermiso == null) {

            throw new IllegalArgumentException(PermisoConstant.INVALID_ID);

        }

        return permisoRepository.update(uuid, permiso);

    }

}
