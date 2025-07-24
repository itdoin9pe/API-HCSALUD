package com.saludsystem.submodules.mantenimiento.service.tipopago;

import com.saludsystem.submodules.mantenimiento.port.repository.TipoPagoRepository;

import java.util.UUID;

public class TipoPagoDeleteService {

    private final TipoPagoRepository tipoPagoRepository;

    public TipoPagoDeleteService(TipoPagoRepository tipoPagoRepository) {
        this.tipoPagoRepository = tipoPagoRepository;
    }

    public void execute(UUID uuid) {
        tipoPagoRepository.delete(uuid);
    }
}
