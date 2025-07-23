package com.saludsystem.submodules.mantenimiento.service.tarifario;

import com.saludsystem.submodules.mantenimiento.mapper.TarifarioMapper;
import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarTarifarioDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.TarifarioRepository;

import java.util.UUID;

public class TarifarioEditService {

    private final TarifarioRepository tarifarioRepository;

    public TarifarioEditService(TarifarioRepository tarifarioRepository) {
        this.tarifarioRepository = tarifarioRepository;
    }

    public Tarifario execute(UUID uuid, ActualizarTarifarioDTO dto) {

        var updateToSave = TarifarioMapper.fromUpdateDto(uuid, dto);

        return tarifarioRepository.update(uuid, updateToSave);

    }

}
