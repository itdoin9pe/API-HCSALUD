package com.saludsystem.submodules.medico.service;

import com.saludsystem.submodules.medico.dtos.DoctorDTO;
import com.saludsystem.submodules.medico.mapper.DoctorMapper;
import com.saludsystem.submodules.medico.port.dao.DoctorDao;

import java.util.UUID;

public class DoctorByIdService {

    private final DoctorDao doctorDao;

    public DoctorByIdService(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public DoctorDTO execute(UUID uuid) {
        return DoctorMapper.toDto(doctorDao.getById(uuid));
    }
}
