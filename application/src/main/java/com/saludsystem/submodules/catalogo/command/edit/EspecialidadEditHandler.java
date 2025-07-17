package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarEspecialidadDTO;
import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadEditHandler {
    private final EspecialidadRepository especialidadRepository;

    public EspecialidadEditHandler(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public void execute(UUID uuid, ActualizarEspecialidadDTO dto) {
        especialidadRepository.update(uuid, EspecialidadMapper.fromUpdateDto(uuid, dto));
    }
}