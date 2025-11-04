package com.saludsystem.submodules.medico.service;

import com.saludsystem.submodules.medico.port.dao.DoctorDao;
import com.saludsystem.submodules.medico.port.repository.DoctorRepository;

import java.util.UUID;

public class DoctorDeleteService {

    private final DoctorRepository doctorRepository;
    private final DoctorDao doctorDao;

    public DoctorDeleteService(DoctorRepository doctorRepository, DoctorDao doctorDao) {
        this.doctorRepository = doctorRepository;
        this.doctorDao = doctorDao;
    }

    public void execute(UUID uuid) {

        var doctor = doctorDao.getById(uuid);

        if (doctor.getEstado() != null && doctor.getEstado() == 0) {

            throw new IllegalStateException("No se puede eliminar un medico ya inhabilitado");

        }

        doctorRepository.delete(uuid);

    }

}
