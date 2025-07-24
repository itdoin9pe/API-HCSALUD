package com.saludsystem.submodules.medico.service;

import com.saludsystem.submodules.medico.dtos.CrearDoctorDTO;
import com.saludsystem.submodules.medico.mapper.DoctorMapper;
import com.saludsystem.submodules.medico.model.Doctor;
import com.saludsystem.submodules.medico.port.repository.DoctorRepository;

public class DoctorCreateService {

    private final DoctorRepository doctorRepository;

    public DoctorCreateService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor execute(CrearDoctorDTO dto) {

        var doctoToSave = DoctorMapper.fromCreateDto(dto);

        return doctorRepository.save(doctoToSave);

    }
}
