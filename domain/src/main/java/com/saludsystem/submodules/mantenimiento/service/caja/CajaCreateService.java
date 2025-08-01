package com.saludsystem.submodules.mantenimiento.service.caja;

import com.saludsystem.submodules.mantenimiento.model.Caja;
import com.saludsystem.submodules.mantenimiento.port.repository.CajaRepository;

public class CajaCreateService {

    private final CajaRepository cajaRepository;

    public CajaCreateService(CajaRepository cajaRepository) {
        this.cajaRepository = cajaRepository;
    }

    public Caja execute(Caja caja) {

        return cajaRepository.save(caja);

    }

}
