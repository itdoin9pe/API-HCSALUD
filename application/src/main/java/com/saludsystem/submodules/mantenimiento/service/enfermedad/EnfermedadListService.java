package com.saludsystem.submodules.mantenimiento.service.enfermedad;

import com.saludsystem.submodules.mantenimiento.mapper.EnfermedadMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.EnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.EnfermedadDao;

import java.util.List;

public class EnfermedadListService {

    private final EnfermedadDao enfermedadDao;

    public EnfermedadListService(EnfermedadDao enfermedadDao) {
        this.enfermedadDao = enfermedadDao;
    }

    public List<EnfermedadDTO> execute() {
        return enfermedadDao.getList()
                .stream()
                .map(EnfermedadMapper::toDto)
                .toList();
    }
}
