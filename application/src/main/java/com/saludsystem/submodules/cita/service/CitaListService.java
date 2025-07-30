package com.saludsystem.submodules.cita.service;

import com.saludsystem.submodules.cita.mapper.CitaMapper;
import com.saludsystem.submodules.cita.dtos.get.CitaDTO;
import com.saludsystem.submodules.cita.port.dao.CitaDao;

import java.util.List;

public class CitaListService {

    private final CitaDao citaDao;

    public CitaListService(CitaDao citaDao) {
        this.citaDao = citaDao;
    }

    public List<CitaDTO> execute() {

        return citaDao.getList()
                .stream()
                .map(CitaMapper::toDto)
                .toList();

    }
}
