package com.saludsystem.submodules.configuracion.service.permiso;

import com.saludsystem.submodules.configuracion.model.Permiso;
import com.saludsystem.submodules.configuracion.port.in.repository.PermisoRepository;
import org.springframework.stereotype.Component;

@Component
public class PermisoCreateService {

    private final PermisoRepository permisoRepository;

    public PermisoCreateService(PermisoRepository permisoRepository) {
        this.permisoRepository = permisoRepository;
    }

    public Permiso execute(Permiso permiso) {

        return permisoRepository.save(permiso);

    }

}
