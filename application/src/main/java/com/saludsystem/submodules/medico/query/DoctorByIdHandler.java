package com.saludsystem.submodules.medico.query;

import com.saludsystem.submodules.medico.mapper.DoctorMapper;
import com.saludsystem.submodules.medico.model.constant.DoctorConstant;
import com.saludsystem.submodules.medico.model.dtos.DoctorDTO;
import com.saludsystem.submodules.medico.port.dao.DoctorDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DoctorByIdHandler {

    private final DoctorDao doctorDao;
    private final DoctorMapper doctorMapper;

    public DoctorByIdHandler(DoctorDao doctorDao, DoctorMapper doctorMapper) {
        this.doctorDao = doctorDao;
        this.doctorMapper = doctorMapper;
    }

    public DoctorDTO execute(UUID uuid) {

        var doctor = doctorDao.getById(uuid);

        if (doctor == null) {

            throw new IllegalArgumentException(DoctorConstant.INVALID_ID);

        }

        return doctorMapper.toDto(doctor);

    }

}
