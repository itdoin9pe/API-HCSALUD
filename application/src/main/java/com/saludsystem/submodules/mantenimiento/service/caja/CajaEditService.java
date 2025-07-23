package com.saludsystem.submodules.mantenimiento.service.caja;

import com.saludsystem.submodules.mantenimiento.mapper.CajaMapper;
import com.saludsystem.submodules.mantenimiento.model.Caja;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarCajaDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.CajaRepository;

import java.util.UUID;

public class CajaEditService {

    private final CajaRepository cajaRepository;

    public CajaEditService(CajaRepository cajaRepository) {
        this.cajaRepository = cajaRepository;
    }

    public Caja execute(UUID uuid, ActualizarCajaDTO dto) {
        var saveToUpdate = CajaMapper.fromUpdateDto(uuid, dto);
        return cajaRepository.update(uuid, saveToUpdate);
    }
}
