package com.saludsystem.submodules.mantenimiento.service.tipotarjeta;

import com.saludsystem.submodules.mantenimiento.mapper.TipoTarjetaMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearTipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoTarjetaRepository;

public class TipoTarjetaCreateService {

    private final TipoTarjetaRepository tipoTarjetaRepository;

    public TipoTarjetaCreateService(TipoTarjetaRepository tipoTarjetaRepository) {
        this.tipoTarjetaRepository = tipoTarjetaRepository;
    }

    public TipoTarjeta execute(CrearTipoTarjetaDTO dto) {

        var tipoTarjetaToSave = TipoTarjetaMapper.fromCreateDto(dto);

        return tipoTarjetaRepository.save(tipoTarjetaToSave);

    }

}
