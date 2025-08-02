package com.saludsystem.submodules.medico.service;

import com.saludsystem.submodules.medico.model.Doctor;
import com.saludsystem.submodules.medico.port.dao.DoctorDao;
import com.saludsystem.submodules.medico.port.repository.DoctorRepository;

import java.util.UUID;

public class DoctorEditService {

    private final DoctorDao doctorDao;
    private final DoctorRepository doctorRepository;

    public DoctorEditService(DoctorDao doctorDao, DoctorRepository doctorRepository) {
        this.doctorDao = doctorDao;
        this.doctorRepository = doctorRepository;
    }

    public Doctor execute(UUID uuid, Doctor doctor) {

        var currentDoctor = doctorDao.getById(uuid);

        if (currentDoctor.getEstado() != null && currentDoctor.getEstado() == 0) {

            throw new IllegalStateException("El Medico ya se encuentra deshabilitado");

        }

        return doctorRepository.update(uuid, doctor);

    }

}
