package com.saludsystem.submodules.mantenimiento.service.tipopago;

import com.saludsystem.submodules.mantenimiento.mapper.TipoPagoMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoPago;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarTipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoPagoRepository;

import java.util.UUID;

public class TipoPagoEditService {

    private final TipoPagoRepository tipoPagoRepository;

    public TipoPagoEditService(TipoPagoRepository tipoPagoRepository) {
        this.tipoPagoRepository = tipoPagoRepository;
    }

    public TipoPago execute(UUID uuid, ActualizarTipoPagoDTO dto) {

        var tipoPagoToUpdate = TipoPagoMapper.fromUpdateDto(uuid,dto);

        return tipoPagoRepository.update(uuid, tipoPagoToUpdate);

    }
}
