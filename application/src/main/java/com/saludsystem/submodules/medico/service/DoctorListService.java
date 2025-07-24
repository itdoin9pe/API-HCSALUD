package com.saludsystem.submodules.medico.service;

import com.saludsystem.submodules.medico.dtos.DoctorDTO;
import com.saludsystem.submodules.medico.mapper.DoctorMapper;
import com.saludsystem.submodules.medico.port.dao.DoctorDao;

import java.util.List;

public class DoctorListService {

    private final DoctorDao doctorDao;

    public DoctorListService(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public List<DoctorDTO> execute() {
        return doctorDao.getList()
                .stream()
                .map(DoctorMapper::toDto)
                .toList();
    }
}
