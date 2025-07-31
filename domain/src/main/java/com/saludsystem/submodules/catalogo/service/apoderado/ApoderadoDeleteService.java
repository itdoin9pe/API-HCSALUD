package com.saludsystem.submodules.catalogo.service.apoderado;

import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import com.saludsystem.submodules.catalogo.port.repository.ApoderadoRepository;

import java.util.UUID;

public class ApoderadoDeleteService {

    private final ApoderadoRepository apoderadoRepository;
    private final ApoderadoDao apoderadoDao;

    public ApoderadoDeleteService(ApoderadoRepository apoderadoRepository, ApoderadoDao apoderadoDao) {
        this.apoderadoRepository = apoderadoRepository;
        this.apoderadoDao = apoderadoDao;
    }

    public void execute(UUID uuid) {

        var apoderado = apoderadoDao.getById(uuid);

        if (apoderado.getEstado() != null && apoderado.getEstado() == 0) {
            throw new IllegalStateException("No se puede eliminar el apoderado, ya se encuentra desactivado");
        }

        apoderadoRepository.delete(uuid);

    }

}
