package com.saludsystem.submodules.mantenimiento.service.caja;

import com.saludsystem.submodules.mantenimiento.model.Caja;
import com.saludsystem.submodules.mantenimiento.port.dao.CajaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.CajaRepository;

import java.util.UUID;

public class CajaEditService {

    private final CajaDao cajaDao;
    private final CajaRepository cajaRepository;

    public CajaEditService(CajaDao cajaDao, CajaRepository cajaRepository) {
        this.cajaDao = cajaDao;
        this.cajaRepository = cajaRepository;
    }

    public Caja execute(UUID uuid, Caja caja) {

        var currentCaja = cajaDao.getById(uuid);

        if (currentCaja.getEstado() != null && currentCaja.getEstado() == 0) {

            throw new IllegalStateException("El tipo de caja ya se encuentra desactivado");

        }

        return cajaRepository.update(uuid, caja);

    }

}
