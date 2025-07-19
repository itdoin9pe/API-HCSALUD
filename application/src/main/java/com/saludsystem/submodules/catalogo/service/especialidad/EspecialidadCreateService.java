package com.saludsystem.submodules.catalogo.service.especialidad;

import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.model.dto.command.CrearEspecialidadDTO;
import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;

public class EspecialidadCreateService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadCreateService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public Especialidad execute(CrearEspecialidadDTO dto) {
        var especialidadToCreate = EspecialidadMapper.fromCreateDto(dto);
        return especialidadRepository.save(especialidadToCreate);
    }
}
