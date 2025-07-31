package com.saludsystem.submodules.catalogo.service.tipocitado;

import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.catalogo.port.repository.TipoCitadoRepository;

public class TipoCitadoCreateService {

    private final TipoCitadoRepository tipoCitadoRepository;

    public TipoCitadoCreateService(TipoCitadoRepository tipoCitadoRepository) {
        this.tipoCitadoRepository = tipoCitadoRepository;
    }

    public TipoCitado execute(TipoCitado model) {

        return tipoCitadoRepository.save(model);

    }

}
