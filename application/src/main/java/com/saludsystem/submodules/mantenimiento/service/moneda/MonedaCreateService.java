package com.saludsystem.submodules.mantenimiento.service.moneda;

import com.saludsystem.submodules.mantenimiento.mapper.MonedaMapper;
import com.saludsystem.submodules.mantenimiento.model.Moneda;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearMonedaDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.MonedaRepository;

public class MonedaCreateService {

    private final MonedaRepository monedaRepository;

    public MonedaCreateService(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    public Moneda execute(CrearMonedaDTO dto) {
        var monedaToSave = MonedaMapper.fromCreateDto(dto);
        return monedaRepository.save(monedaToSave);
    }
}
