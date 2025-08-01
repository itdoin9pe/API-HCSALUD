package com.saludsystem.submodules.mantenimiento.service.moneda;

import com.saludsystem.submodules.mantenimiento.model.Moneda;
import com.saludsystem.submodules.mantenimiento.port.dao.MonedaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.MonedaRepository;

import java.util.UUID;

public class MonedaEditService {

    private final MonedaDao monedaDao;
    private final MonedaRepository monedaRepository;

    public MonedaEditService(MonedaDao monedaDao, MonedaRepository monedaRepository) {
        this.monedaDao = monedaDao;
        this.monedaRepository = monedaRepository;
    }

    public Moneda execute(UUID uuid, Moneda moneda) {

        var currentMoneda = monedaDao.getById(uuid);

        if (currentMoneda.getEstado() != null && currentMoneda.getEstado() == 0) {

            throw new IllegalStateException("El tipo de moneda ya se encuentra desactivado");

        }

        return monedaRepository.update(uuid, moneda);

    }

}
