package com.saludsystem.submodules.catalogo.service.tipocitado;

import com.saludsystem.submodules.catalogo.port.repository.TipoCitadoRepository;

import java.util.UUID;

public class TipoCitadoDeleteService {

    private final TipoCitadoRepository tipoCitadoRepository;

    public TipoCitadoDeleteService(TipoCitadoRepository tipoCitadoRepository) {
        this.tipoCitadoRepository = tipoCitadoRepository;
    }

    public void execute(UUID uuid) {
        tipoCitadoRepository.delete(uuid);
    }

}