package com.saludsystem.submodules.mantenimiento.service.tipopago;

import com.saludsystem.submodules.mantenimiento.mapper.TipoPagoMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoPago;
import com.saludsystem.submodules.mantenimiento.dtos.post.CrearTipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoPagoRepository;

public class TipoPagoCreateService {

    private final TipoPagoRepository tipoPagoRepository;

    public TipoPagoCreateService(TipoPagoRepository tipoPagoRepository) {
        this.tipoPagoRepository = tipoPagoRepository;
    }

    public TipoPago execute(CrearTipoPagoDTO dto) {

        var tipoPagoToSaved = TipoPagoMapper.fromCreateDto(dto);

        return tipoPagoRepository.save(tipoPagoToSaved);

    }
}
