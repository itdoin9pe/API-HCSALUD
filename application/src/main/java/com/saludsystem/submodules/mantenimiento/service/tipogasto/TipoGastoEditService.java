package com.saludsystem.submodules.mantenimiento.service.tipogasto;

import com.saludsystem.submodules.mantenimiento.mapper.TipoGastoMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoGasto;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarTipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoGastoRepository;

import java.util.UUID;

public class TipoGastoEditService {

    private final TipoGastoRepository tipoGastoRepository;

    public TipoGastoEditService(TipoGastoRepository tipoGastoRepository) {
        this.tipoGastoRepository = tipoGastoRepository;
    }

    public TipoGasto execute(UUID uuid, ActualizarTipoGastoDTO dto) {
        var updated = TipoGastoMapper.fromUpdateDto(uuid, dto);
        return tipoGastoRepository.update(uuid, updated);
    }

}
