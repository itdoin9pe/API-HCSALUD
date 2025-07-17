package com.saludsystem.submodules.catalogo.service.alergia;

import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarAlergiaDTO;
import com.saludsystem.submodules.catalogo.port.repository.AlergiaRepository;

import java.util.UUID;

public class AlergiaEditService {

    private final AlergiaRepository alergiaRepository;

    public AlergiaEditService(AlergiaRepository alergiaRepository) {
        this.alergiaRepository = alergiaRepository;
    }

    public Alergia execute(UUID uuid, ActualizarAlergiaDTO dto) {
        var updateToSave = AlergiaMapper.fromUpdateDto(uuid, dto);
        return alergiaRepository.update(uuid, updateToSave);
    }
}
