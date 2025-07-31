package com.saludsystem.submodules.catalogo.service.alergia;

import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import com.saludsystem.submodules.catalogo.port.repository.AlergiaRepository;

import java.util.UUID;

public class AlergiaDeleteService {

    private final AlergiaRepository alergiaRepository;
    private final AlergiaDao alergiaDao;

    public AlergiaDeleteService(AlergiaRepository alergiaRepository, AlergiaDao alergiaDao) {
        this.alergiaRepository = alergiaRepository;
        this.alergiaDao = alergiaDao;
    }

    public void execute(UUID uuid) {

        var alergia = alergiaDao.getById(uuid);

        if (alergia.getEstado() != null && alergia.getEstado() == 0) {
            throw new IllegalStateException("No se puede eliminar una alergia ya desactivada");
        }

        alergiaRepository.delete(uuid);

    }

}
