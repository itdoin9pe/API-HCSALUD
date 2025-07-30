package com.saludsystem.submodules.catalogo.service.medida;

import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.dto.edit.ActualizarMedidaDTO;
import com.saludsystem.submodules.catalogo.port.repository.MedidaRepository;

import java.util.UUID;

public class MedidaEditService {

    private final MedidaRepository medidaRepository;

    public MedidaEditService(MedidaRepository medidaRepository) {
        this.medidaRepository = medidaRepository;
    }

    public Medida execute(UUID uuid, ActualizarMedidaDTO dto) {
        var updateToSave = MedidaMapper.fromUpdateDto(uuid, dto);
        return medidaRepository.update(uuid, updateToSave);
    }
}
