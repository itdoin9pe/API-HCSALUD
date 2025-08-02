package com.saludsystem.submodules.medico.query;

import com.saludsystem.submodules.medico.mapper.DoctorMapper;
import com.saludsystem.submodules.medico.model.Doctor;
import com.saludsystem.submodules.medico.model.dtos.DoctorDTO;
import com.saludsystem.submodules.medico.port.dao.DoctorDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorListHandler {

    private final DoctorDao doctorDao;
    private final DoctorMapper doctorMapper;

    public DoctorListHandler(DoctorDao doctorDao, DoctorMapper doctorMapper) {
        this.doctorDao = doctorDao;
        this.doctorMapper = doctorMapper;
    }

    public List<DoctorDTO> execute() {

        List<Doctor> doctorList = doctorDao.getList();

        return doctorList.stream()
                .map(doctorMapper::toDto)
                .toList();

    }

}
