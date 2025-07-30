package com.saludsystem.submodules.catalogo.service.apoderado;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.dto.edit.ActualizarApoderadoDTO;
import com.saludsystem.submodules.catalogo.port.repository.ApoderadoRepository;

import java.util.UUID;

public class ApoderadoEditService {

    private final ApoderadoRepository apoderadoRepository;

    public ApoderadoEditService(ApoderadoRepository apoderadoRepository) {
        this.apoderadoRepository = apoderadoRepository;
    }

    public Apoderado execute(UUID uuid, ActualizarApoderadoDTO dto) {
        var updateToSave = ApoderadoMapper.fromUpdateDto(uuid, dto);
        return apoderadoRepository.update(uuid, updateToSave);
    }
}
