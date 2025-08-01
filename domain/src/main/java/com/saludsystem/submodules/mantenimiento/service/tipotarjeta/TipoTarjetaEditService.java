package com.saludsystem.submodules.mantenimiento.service.tipotarjeta;

import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoTarjetaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoTarjetaRepository;

import java.util.UUID;

public class TipoTarjetaEditService {

    private final TipoTarjetaDao tipoTarjetaDao;
    private final TipoTarjetaRepository tipoTarjetaRepository;

    public TipoTarjetaEditService(TipoTarjetaDao tipoTarjetaDao, TipoTarjetaRepository tipoTarjetaRepository) {
        this.tipoTarjetaDao = tipoTarjetaDao;
        this.tipoTarjetaRepository = tipoTarjetaRepository;
    }

    public TipoTarjeta execute(UUID uuid, TipoTarjeta tipoTarjeta) {

        var currentTipoTarjeta = tipoTarjetaDao.getById(uuid);

        if (currentTipoTarjeta.getEstado() != null && currentTipoTarjeta.getEstado() == 0) {

            throw new IllegalStateException("El tipo de tarjeta ya se encuentra desactivado");

        }

        return tipoTarjetaRepository.update(uuid, tipoTarjeta);

    }

}
