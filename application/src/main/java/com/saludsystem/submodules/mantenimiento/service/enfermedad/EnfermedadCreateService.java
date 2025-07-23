package com.saludsystem.submodules.mantenimiento.service.enfermedad;

import com.saludsystem.submodules.mantenimiento.mapper.EnfermedadMapper;
import com.saludsystem.submodules.mantenimiento.model.Enfermedad;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearEnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.EnfermedadRepository;

public class EnfermedadCreateService {

    private final EnfermedadRepository enfermedadRepository;

    public EnfermedadCreateService(EnfermedadRepository enfermedadRepository) {
        this.enfermedadRepository = enfermedadRepository;
    }

    public Enfermedad execute(CrearEnfermedadDTO dto) {
        var enfermedadToSave = EnfermedadMapper.fromCreateDto(dto);
        return enfermedadRepository.save(enfermedadToSave);
    }
}
