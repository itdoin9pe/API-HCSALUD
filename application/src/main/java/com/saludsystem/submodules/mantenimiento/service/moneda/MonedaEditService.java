package com.saludsystem.submodules.mantenimiento.service.moneda;

import com.saludsystem.submodules.mantenimiento.mapper.MonedaMapper;
import com.saludsystem.submodules.mantenimiento.model.Moneda;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarMonedaDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.MonedaRepository;

import java.util.UUID;

public class MonedaEditService {

    private final MonedaRepository monedaRepository;

    public MonedaEditService(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    public Moneda execute(UUID uuid, ActualizarMonedaDTO dto) {
        var updateToSave = MonedaMapper.fromUpdateDto(uuid, dto);
        return monedaRepository.update(uuid, updateToSave);
    }
}
