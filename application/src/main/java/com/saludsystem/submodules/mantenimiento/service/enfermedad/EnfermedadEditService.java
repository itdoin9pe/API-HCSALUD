package com.saludsystem.submodules.mantenimiento.service.enfermedad;

import com.saludsystem.submodules.mantenimiento.mapper.EnfermedadMapper;
import com.saludsystem.submodules.mantenimiento.model.Enfermedad;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarEnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.port.service.EnfermedadRepository;

public class EnfermedadEditService {

    private final EnfermedadRepository enfermedadRepository;

    public EnfermedadEditService(EnfermedadRepository enfermedadRepository) {
        this.enfermedadRepository = enfermedadRepository;
    }

    public Enfermedad execute(String id, ActualizarEnfermedadDTO dto) {
        var updateToSave = EnfermedadMapper.fromUpdateDto(id, dto);
        return enfermedadRepository.save(updateToSave);
    }

}
