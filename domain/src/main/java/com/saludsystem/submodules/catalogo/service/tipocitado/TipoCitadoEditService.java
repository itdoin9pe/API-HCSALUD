package com.saludsystem.submodules.catalogo.service.tipocitado;

import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import com.saludsystem.submodules.catalogo.port.repository.TipoCitadoRepository;

import java.util.UUID;

public class TipoCitadoEditService {

    private final TipoCitadoDao tipoCitadoDao;
    private final TipoCitadoRepository tipoCitadoRepository;

    public TipoCitadoEditService(TipoCitadoDao tipoCitadoDao, TipoCitadoRepository tipoCitadoRepository) {
        this.tipoCitadoDao = tipoCitadoDao;
        this.tipoCitadoRepository = tipoCitadoRepository;
    }

    public TipoCitado execute(UUID uuid, TipoCitado model) {

        var currentTipoCitado = tipoCitadoDao.getById(uuid);

        if (currentTipoCitado.getEstado() != null && currentTipoCitado.getEstado() == 0) {

            throw new IllegalStateException("El tipo citado ya se encuentra desactivado");

        }

        return tipoCitadoRepository.update(uuid, model);

    }

}
