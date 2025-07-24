package com.saludsystem.submodules.mantenimiento.service.tipotarjeta;

import com.saludsystem.submodules.mantenimiento.mapper.TipoTarjetaMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarTipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoTarjetaRepository;

import java.util.UUID;

public class TipoTarjetaEditService {

    private final TipoTarjetaRepository tipoTarjetaRepository;

    public TipoTarjetaEditService(TipoTarjetaRepository tipoTarjetaRepository) {
        this.tipoTarjetaRepository = tipoTarjetaRepository;
    }

    public TipoTarjeta execute(UUID uuid, ActualizarTipoTarjetaDTO dto) {

        var updated = TipoTarjetaMapper.fromUpdateDto(uuid, dto);

        return tipoTarjetaRepository.update(uuid, updated);

    }
}
