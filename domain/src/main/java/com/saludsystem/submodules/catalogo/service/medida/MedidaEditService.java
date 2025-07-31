package com.saludsystem.submodules.catalogo.service.medida;

import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import com.saludsystem.submodules.catalogo.port.repository.MedidaRepository;

import java.util.UUID;

public class MedidaEditService {

    private final MedidaDao medidaDao;
    private final MedidaRepository medidaRepository;

    public MedidaEditService(MedidaDao medidaDao, MedidaRepository medidaRepository) {
        this.medidaDao = medidaDao;
        this.medidaRepository = medidaRepository;
    }

    public Medida execute(UUID uuid, Medida model) {

        var currentMedida = medidaDao.getById(uuid);

        if (currentMedida.getEstado() != null && currentMedida.getEstado() == 0) {

            throw new IllegalStateException("La medida ya se encuentra desactivada");

        }

        return medidaRepository.update(uuid, model);

    }

}
