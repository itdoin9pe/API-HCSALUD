package com.saludsystem.submodules.cita.service;

import com.saludsystem.submodules.cita.mapper.CitaMapper;
import com.saludsystem.submodules.cita.model.dtos.post.CrearCitaDTO;
import com.saludsystem.submodules.cita.port.repository.CitaRepository;

public class CitaCreateService {

    private final CitaRepository citaRepository;

    public CitaCreateService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public void execute(CrearCitaDTO dto) {

        var citaToSave = CitaMapper.fromCreateDto(dto);

        citaRepository.save(citaToSave);

    }

}
