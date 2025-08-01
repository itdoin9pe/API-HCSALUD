package com.saludsystem.submodules.mantenimiento.service.caja;

import com.saludsystem.submodules.mantenimiento.port.dao.CajaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.CajaRepository;

import java.util.UUID;

public class CajaDeleteService {

    private final CajaRepository cajaRepository;
    private final CajaDao cajaDao;

    public CajaDeleteService(CajaRepository cajaRepository, CajaDao cajaDao) {
        this.cajaRepository = cajaRepository;
        this.cajaDao = cajaDao;
    }

    public void execute(UUID uuid) {

        var caja = cajaDao.getById(uuid);

        if (caja.getEstado() != null && caja.getEstado() == 0) {

            throw new IllegalStateException("No se puede eliminar un tipo de caja ya desactivada");

        }

        cajaRepository.delete(uuid);

    }

}
