package com.saludsystem.submodules.catalogo.service.especialidad;

import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;

import java.util.UUID;

public class EspecialidadDeleteService {

    private final EspecialidadRepository especialidadRepository;
    private final EspecialidadDao especialidadDao;

    public EspecialidadDeleteService(EspecialidadRepository especialidadRepository, EspecialidadDao especialidadDao) {
        this.especialidadRepository = especialidadRepository;
        this.especialidadDao = especialidadDao;
    }

    public void execute(UUID uuid) {

        var especialidad = especialidadDao.getById(uuid);

        if (especialidad.getEstado() != null && especialidad.getEstado() == 0) {

            throw new IllegalStateException("No se puede eliminar una especialidad ya desactivada");

        }

        especialidadRepository.delete(uuid);

    }

}
