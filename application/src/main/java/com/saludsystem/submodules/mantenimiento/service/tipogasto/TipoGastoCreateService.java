package com.saludsystem.submodules.mantenimiento.service.tipogasto;

import com.saludsystem.submodules.mantenimiento.mapper.TipoGastoMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoGasto;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearTipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoGastoRepository;

public class TipoGastoCreateService {

    private final TipoGastoRepository tipoGastoRepository;

    public TipoGastoCreateService(TipoGastoRepository tipoGastoRepository) {
        this.tipoGastoRepository = tipoGastoRepository;
    }

    public TipoGasto execute(CrearTipoGastoDTO dto) {
        var saved = TipoGastoMapper.fromCreateDto(dto);
        return tipoGastoRepository.save(saved);
    }
}
