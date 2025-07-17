package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearEspecialidadDTO;
import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;
import org.springframework.stereotype.Component;

@Component
public class EspecialidadCreateHandler {
    private final EspecialidadRepository especialidadRepository;

    public EspecialidadCreateHandler(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public void execute(CrearEspecialidadDTO dto) {
        especialidadRepository.save(EspecialidadMapper.fromCreateDto(dto));
    }

}