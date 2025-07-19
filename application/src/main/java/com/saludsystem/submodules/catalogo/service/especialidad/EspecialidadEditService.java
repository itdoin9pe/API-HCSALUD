package com.saludsystem.submodules.catalogo.service.especialidad;

import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarEspecialidadDTO;
import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;

import java.util.UUID;

public class EspecialidadEditService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadEditService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public Especialidad execute(UUID uuid, ActualizarEspecialidadDTO dto) {
        var updateToSave = EspecialidadMapper.fromUpdateDto(uuid, dto);
        return especialidadRepository.update(uuid, updateToSave);
    }
}
