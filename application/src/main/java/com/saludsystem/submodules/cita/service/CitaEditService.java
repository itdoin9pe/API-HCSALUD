package com.saludsystem.submodules.cita.service;

import com.saludsystem.submodules.cita.mapper.CitaMapper;
import com.saludsystem.submodules.cita.dtos.put.ActualizarCitaDTO;
import com.saludsystem.submodules.cita.model.entity.Cita;
import com.saludsystem.submodules.cita.port.repository.CitaRepository;

import java.util.UUID;

public class CitaEditService {

    private final CitaRepository citaRepository;

    public CitaEditService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public Cita execute(UUID uuid, ActualizarCitaDTO dto) {

        var updateToSave = CitaMapper.fromUpdateDto(uuid, dto);

        return citaRepository.update(uuid, updateToSave);

    }
}
