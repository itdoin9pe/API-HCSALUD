package com.saludsystem.submodules.principal.service.aseguradora;

import com.saludsystem.submodules.principal.port.dao.AseguradoraDao;
import com.saludsystem.submodules.principal.port.repository.AseguradoraRepository;

import java.util.UUID;

public class AseguradoraDeleteService {

    private final AseguradoraRepository aseguradoraRepository;
    private final AseguradoraDao aseguradoraDao;

    public AseguradoraDeleteService(AseguradoraRepository aseguradoraRepository, AseguradoraDao aseguradoraDao) {
        this.aseguradoraRepository = aseguradoraRepository;
        this.aseguradoraDao = aseguradoraDao;
    }

    public void execute(UUID uuid) {

        var aseguradora = aseguradoraDao.getById(uuid);

        if (aseguradora.getEstado() != null && aseguradora.getEstado() == 0) {
            throw new IllegalStateException("No se puede eliminar una aseguradora ya desactivada");
        }

        aseguradoraRepository.delete(uuid);
    }

}
