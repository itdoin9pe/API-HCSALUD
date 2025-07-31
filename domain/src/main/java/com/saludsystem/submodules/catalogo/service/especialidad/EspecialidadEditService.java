package com.saludsystem.submodules.catalogo.service.especialidad;

import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;

import java.util.UUID;

public class EspecialidadEditService {

    private final EspecialidadDao especialidadDao;
    private final EspecialidadRepository especialidadRepository;

    public EspecialidadEditService(EspecialidadDao especialidadDao, EspecialidadRepository especialidadRepository) {
        this.especialidadDao = especialidadDao;
        this.especialidadRepository = especialidadRepository;
    }

    public Especialidad execute(UUID uuid, Especialidad model) {

        var currrentEspecialidad = especialidadDao.getById(uuid);

        if (currrentEspecialidad.getEstado() != null && currrentEspecialidad.getEstado() == 0) {

            throw new IllegalStateException("La especialidad ya se encuentra desactivada");

        }

        return especialidadRepository.update(uuid, model);

    }

}
