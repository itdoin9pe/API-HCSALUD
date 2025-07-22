package com.saludsystem.submodules.mantenimiento.service.caja;

import com.saludsystem.submodules.mantenimiento.mapper.CajaMapper;
import com.saludsystem.submodules.mantenimiento.model.Caja;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearCajaDTO;
import com.saludsystem.submodules.mantenimiento.port.service.CajaRepository;

public class CajaCreateService {

    private final CajaRepository cajaRepository;

    public CajaCreateService(CajaRepository cajaRepository) {
        this.cajaRepository = cajaRepository;
    }

    public Caja execute(CrearCajaDTO dto) {
        var cajaToSave = CajaMapper.fromCreateDto(dto);
        return cajaRepository.save(cajaToSave);
    }
}
