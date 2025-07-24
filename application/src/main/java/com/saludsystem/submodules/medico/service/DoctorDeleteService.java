package com.saludsystem.submodules.medico.service;

import com.saludsystem.submodules.medico.port.repository.DoctorRepository;

import java.util.UUID;

public class DoctorDeleteService {

    private final DoctorRepository doctorRepository;

    public DoctorDeleteService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void execute(UUID uuid) {
        doctorRepository.delete(uuid);
    }

}
