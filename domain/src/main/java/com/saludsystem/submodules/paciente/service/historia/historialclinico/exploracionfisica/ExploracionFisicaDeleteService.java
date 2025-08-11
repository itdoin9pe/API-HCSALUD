package com.saludsystem.submodules.paciente.service.historia.historialclinico.exploracionfisica;

import com.saludsystem.submodules.paciente.port.dao.historialclinico.ExploracionFisicaDao;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.ExploracionFisicaRepository;

import java.util.UUID;

public class ExploracionFisicaDeleteService {

    private final ExploracionFisicaRepository exploracionFisicaRepository;
    private final ExploracionFisicaDao exploracionFisicaDao;

    public ExploracionFisicaDeleteService(ExploracionFisicaRepository exploracionFisicaRepository, ExploracionFisicaDao exploracionFisicaDao) {
        this.exploracionFisicaRepository = exploracionFisicaRepository;
        this.exploracionFisicaDao = exploracionFisicaDao;
    }

    public void excute(UUID uuid) {

        var exploracionFisica = exploracionFisicaDao.getById(uuid);

        if (exploracionFisica.getTalla() != null && exploracionFisica.getTalla().equals(" ")) {

            throw new IllegalStateException("No se puede eliminar una exploracion sin talla del paciente registrada");

        }

        exploracionFisicaRepository.delete(uuid);

    }

}
