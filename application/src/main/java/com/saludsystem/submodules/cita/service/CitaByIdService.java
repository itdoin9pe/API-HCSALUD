package com.saludsystem.submodules.cita.service;

import com.saludsystem.submodules.cita.mapper.CitaMapper;
import com.saludsystem.submodules.cita.dtos.get.CitaDTO;
import com.saludsystem.submodules.cita.port.dao.CitaDao;

import java.util.UUID;

public class CitaByIdService {

    private final CitaDao citaDao;

    public CitaByIdService(CitaDao citaDao) {
        this.citaDao = citaDao;
    }

    public CitaDTO execute(UUID uuid) {

        return CitaMapper.toDto(citaDao.getById(uuid));

    }

}
