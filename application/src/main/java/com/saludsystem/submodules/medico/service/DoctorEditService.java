package com.saludsystem.submodules.medico.service;

import com.saludsystem.submodules.medico.dtos.ActualizarDoctorDTO;
import com.saludsystem.submodules.medico.mapper.DoctorMapper;
import com.saludsystem.submodules.medico.model.Doctor;
import com.saludsystem.submodules.medico.port.repository.DoctorRepository;

import java.util.UUID;

public class DoctorEditService {

    private final DoctorRepository doctorRepository;

    public DoctorEditService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor execute(UUID uuid, ActualizarDoctorDTO dto) {

        var doctorToUpdate = DoctorMapper.fromUpdateDto(uuid, dto);

        return doctorRepository.update(uuid, doctorToUpdate);

    }

}
