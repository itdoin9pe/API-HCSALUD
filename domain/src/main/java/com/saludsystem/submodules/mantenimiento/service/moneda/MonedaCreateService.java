package com.saludsystem.submodules.mantenimiento.service.moneda;

import com.saludsystem.submodules.mantenimiento.model.Moneda;
import com.saludsystem.submodules.mantenimiento.port.repository.MonedaRepository;

public class MonedaCreateService {

    private final MonedaRepository monedaRepository;

    public MonedaCreateService(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    public Moneda execute(Moneda moneda) {

        return monedaRepository.save(moneda);

    }

}
