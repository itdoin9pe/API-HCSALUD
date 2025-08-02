package com.saludsystem.submodules.medico.service;

import com.saludsystem.submodules.medico.model.Doctor;
import com.saludsystem.submodules.medico.port.repository.DoctorRepository;

public class DoctorCreateService {

    private final DoctorRepository doctorRepository;

    public DoctorCreateService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor execute(Doctor doctor) {

        return doctorRepository.save(doctor);

    }

}
