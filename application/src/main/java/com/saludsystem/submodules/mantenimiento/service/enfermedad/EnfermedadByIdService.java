package com.saludsystem.submodules.mantenimiento.service.enfermedad;

import com.saludsystem.submodules.mantenimiento.mapper.EnfermedadMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.EnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.EnfermedadDao;

public class EnfermedadByIdService {

    private final EnfermedadDao enfermedadDao;

    public EnfermedadByIdService(EnfermedadDao enfermedadDao) {
        this.enfermedadDao = enfermedadDao;
    }

    public EnfermedadDTO execute(String id) {
        return EnfermedadMapper.toDto(enfermedadDao.getById(id));
    }

}
